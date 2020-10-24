package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.VendorServiceImplement;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/vendor")
public class VendorApi {
    private static final Logger log = LoggerFactory.getLogger(VendorApi.class);

    @Autowired
    private VendorServiceImplement vendorService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/list")
    public ResponseData<MultiMap> list (@RequestParam("userId") int user_id, @RequestParam("lang") String lang) throws Exception {
        ResponseData<MultiMap> responseData = new ResponseData<>();
        try {
          log.info("\n\n<<<===****Start Vendor get list***====>>>\n\n");

          MMap input = new MMap();
          input.setString("status", Status.Delete.getValueStr());

          MultiMap responseBody = vendorService.retrieveList(input);
          responseData.setBody(responseBody);

          log.info("\n\n<<<===****Vendor list value:"+responseData+"***====>>>\n\n");
          log.info("\n\n<<<===****End Vendor get list***====>>>\n\n");

        } catch (ValidatorException ex) {
            log.error("get error", ex);
            ex.printStackTrace();
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            log.error("get error", e);
            e.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        return execute("save", user_id, lang, param.getMMap("body"));
    }

    @PostMapping(value = "/update")
    public ResponseData<MMap> update (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        return execute("update", user_id, lang, param.getMMap("body"));
    }

    @PostMapping(value = "/delete")
    public ResponseData<MMap> delete(@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        return delete(user_id, lang, param.getMultiMap("body"));
    }

    private ResponseData<MMap> execute(String function, int user_id, String lang, MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            MMap input = new MMap();
            MMap out = new MMap();
            out.setString("status", "N");

            input.setInt("user_id",     user_id);
            input.setString("name",     param.getString("name"));
            input.setString("contact",  param.getString("contact"));
            input.setString("email",    param.getString("email"));
            input.setString("description", param.getString("description"));
            input.setString("other_contact", param.getString("other_contact"));
            input.setString("address", param.getString("address"));
            input.setString("status", Status.Active.getValueStr());

            if (function == "save") {
                int id = vendorService.sequence();
                input.setInt("id",          id);
                Long save = vendorService.save(input);
                if (save > 0 ) {
                    out.setString("status", "Y");
                }

            } else if (function == "update") {
                input.setInt("id",          param.getInt("id"));
                Long update = vendorService.update(input);
                if (update > 0) {
                    out.setString("status", "Y");
                }
            }

            responseData.setBody(out);

            log.info("\n\n<<<===****Vendor response : "+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End Vendor save api***====>>>\n\n");
        } catch (ValidatorException ex) {
            log.error("get error", ex);
            ex.printStackTrace();
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            log.error("error exception",e);
            e.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    private ResponseData<MMap> delete(int user_id, String lang, MultiMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            log.info("\n\n***Start");
            log.info("\n\n*** Data delete: "+param);

            MMap out = new MMap();
            out.setString("status", "N");
            if(param.size() > 0) {
                MMap input = new MMap();
                for (MMap data : param.toListData()) {
                    input.setInt("id", data.getInt("id"));
                    input.setInt("user_id", user_id);
                    input.setString("status", Status.Delete.getValueStr());
                    vendorService.delete(input);
                }

                transactionManager.commit(transactionStatus);
                out.setString("status", "Y");
                responseData.setBody(out);
            }
            log.info("\n\n***End");
        }  catch (ValidatorException ex) {
            log.error("get error", ex);
            ex.printStackTrace();
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            log.error("get error", e);
            e.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "vendor_"+key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        } else if ("status".equals(key)) {
            message = Translator.toLocale(lang, "status");
        } else if ("user_id".equals(key)) {
            message = Translator.toLocale(lang, "user_id");
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }
}
