package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.ProductServiceImplement;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product")
public class ProductAPI {

    private static final Logger log = LoggerFactory.getLogger(ProductAPI.class);
    @Autowired
    private ProductServiceImplement productService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/list")
    public ResponseData<MultiMap> list(@RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        return getProductList(lang);
    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) {
        return execute("save", user_id, lang, param.getMMap("body"));
    }

    @PostMapping(value = "/update")
    public ResponseData<MMap> update (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) {
        return execute("update", user_id, lang, param.getMMap("body"));
    }

    @PostMapping(value = "/delete")
    public ResponseData<MMap> delete(@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) {
        return delete(user_id, lang, param.getMultiMap("body"));
    }

    private ResponseData<MMap> execute(String function, int user_id, String lang, MMap param) {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MMap input = new MMap();
            MMap out = new MMap();
            out.setString("status", "N");

            input.setInt("user_id",         user_id);
            input.setString("name",         param.getString("name"));
            input.setString("description",  param.getString("description"));
            input.setString("status",       Status.Active.getValueStr());
            input.setInt("category_id",     param.getInt("category_id"));
            input.setString("resource_img_id", param.getString("resource_img_id"));


            if (function == "save") {
                int id = productService.sequence();
                input.setInt("id",          id);
                log.info("product info:", input);
                Long save = productService.save(input);
                if (save > 0 ) {
                    out.setString("status", "Y");
                }

            } else if (function == "update") {
                input.setInt("id",          param.getInt("id"));
                log.info("product info:", objectMapper.writeValueAsString(input));
                Long update = productService.update(input);
                if (update > 0) {
                    out.setString("status", "Y");
                }
            }

            responseData.setBody(out);

            log.info("\n\n<<<===****Product response : "+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End product "+function+" api***====>>>\n\n");
        } catch (ValidatorException ex) {
            ex.printStackTrace();
            log.error("get error save api product",ex);
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("get error api product save exception",e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    private ResponseData<MMap> delete(int user_id, String lang, MultiMap param) {
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
                    productService.delete(input);
                }

                transactionManager.commit(transactionStatus);
                out.setString("status", "Y");
                responseData.setBody(out);
            }
            log.info("\n\n***End");
        } catch (ValidatorException ex) {
            ex.printStackTrace();
            log.error("get error api product delete",ex);
            Message message = message(ex.getKey(), lang);
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("get error exception api product delete",e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            return responseData;
        }
        return responseData;
    }

    private  ResponseData<MultiMap> getProductList(String lang) {
        ResponseData<MultiMap> responseData = new ResponseData<>();
        try {
            log.info("\n\n<<<===****Start Product get list***====>>>\n\n");

            MMap input = new MMap();
            input.setString("status", Status.Delete.getValueStr());

            MultiMap responseBody = productService.retrieveList(input);
            responseData.setBody(responseBody);

            log.info("\n\n<<<===****Product list value:"+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End Product get list***====>>>\n\n");

        } catch (ValidatorException ex) {
            log.error("get error api product list", ex);
            ex.printStackTrace();
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        }
        catch (Exception e) {
            log.error("get error exception api product list", e);
            e.printStackTrace();
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }


    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "product_"+key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        } else if (ErrorCode.STATUS.equals(key.trim())) {
            message = Translator.toLocale(lang, ErrorCode.STATUS);
        } else if (ErrorCode.USER_ID.equals(key.trim())) {
            message = Translator.toLocale(lang, ErrorCode.USER_ID);
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }

}
