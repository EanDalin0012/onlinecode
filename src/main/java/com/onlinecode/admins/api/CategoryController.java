package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.CategoryServiceImplement;
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
@RequestMapping(value = "/api/category")
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryServiceImplement categoryService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/list")
    public ResponseData<MultiMap> list(@RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        ResponseData<MultiMap> response = new ResponseData<>();
        try {
            log.info("\n\n <<<<=====******Start get list of category******=====>>>\n");
            MMap input = new MMap();
            input.setString("status", Status.Delete.getValueStr());

            MultiMap out    = categoryService.retrieveList(input);
            response.setBody(out);

            log.info("\n\n <<<<=====******result : "+response+"******=====>>>\n");
            log.info("\n\n <<<<=====******End get list of category******=====>>>\n\n");
            return response;
        } catch (ValidatorException ev) {
            log.error("error ValueException api category get list", ev);
            ev.printStackTrace();
            Message message = message(ev.getKey(), lang);
            response.setError(message);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error Exception api category get list", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            response.setError(message);
            return response;
        }

    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            log.info("\n\n<<<=====*******Start save category********====>>>\n\n"+lang);
            MMap body  = param.getMMap("body");

            MMap responseBody = new MMap();
            responseBody.setString("status", "N");

            int sequence = categoryService.sequence();

            MMap input = new MMap();
            input.setInt("id", sequence);
            input.setInt("user_id", user_id);
            input.setString("name", body.getString("name"));
            input.setString("description", body.getString("description"));
            input.setString("status", Status.Active.getValueStr());

            log.info("<<<=====*******start value param: \n"+param+"\n end value********====>>>");
            log.info("<<<=====*******start value: \n"+input+"\n end value********====>>>");

            Long save = categoryService.save(input);
            if (save > 0) {
                responseBody.setString("status", "Y");
            }
            responseData.setBody(responseBody);

            log.info("\n\n<<<=====*******responseData "+responseData+"********====>>>\n\n");
            log.info("\n\n<<<=====*******End save category********====>>>\n\n");
        } catch (ValidatorException ev) {
            log.error("error ValidatorException api category get list", ev);
            ev.printStackTrace();
            Message message = message(ev.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error Exception api save category", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            return responseData;
        }
        return responseData;
    }

    @PostMapping(value = "/update")
    public ResponseData<MMap> update(@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
          log.info("\n\n<<<<<<<======****************Start Update category update data ****************======>>>>>\n\n");

          MMap out = new MMap();
          out.setString("status", "N");

          MMap body = param.getMMap("body");
          MMap input = new MMap();
          input.setInt("user_id", user_id);
          input.setInt("id", body.getInt("id"));
          input.setString("name", body.getString("name"));
          input.setString("description", body.getString("description"));
          input.setString("status", Status.Modify.getValueStr());

          log.info("\n\n<<<<<<<======**************** Update category update data param: "+param+" ****************======>>>>>\n\n");
          log.info("\n\n<<<<<<<======**************** Update category update data  input: "+input+"****************======>>>>>\n\n");

          long update = categoryService.update(input);
          if (update > 0) {
              out.setString("status", "Y");
          }

          responseData.setBody(out);

          log.info("\n\n<<<<<<<======**************** Out put data: "+responseData+" ****************======>>>>>\n\n");
          log.info("\n\n<<<<<<<======****************End Update category update data ****************======>>>>>\n\n");

        } catch (ValidatorException ev){
            ev.printStackTrace();
            log.error("", ev);
            Message message = message(ev.getKey(), lang);
            responseData.setError(message);
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    @PostMapping(value = "/delete")
    public ResponseData<MMap> delete(@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            log.info("\n\n<<<<<============***********Start delete api category delete***********=============>>>>>>>>>>>>>\n\n");
            log.info("\n\n<<<<<============***********Start delete api category param: "+param+"***********=============>>>>>>>>>>>>>\n\n");

            MMap out = new MMap();
            out.setString("status", "N");
            MultiMap body = param.getMultiMap("body");

            if (body.size()>0) {
                MMap input = new MMap();
                for (MMap data : body.toListData()) {
                    input.setInt("id", data.getInt("id"));
                    input.setInt("user_id", user_id);
                    input.setString("status", Status.Delete.getValueStr());
                    categoryService.delete(input);
                }

                transactionManager.commit(transactionStatus);
                out.setString("status", "Y");
                responseData.setBody(out);
            }

        } catch (ValidatorException ev) {
            ev.printStackTrace();
            log.error("error Application Exception api save category", ev);
            Message message = message(ev.getKey(), lang);
            responseData.setError(message);
            return responseData;
        }
        catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            e.printStackTrace();
            log.error("", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }
        return responseData;
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "category_"+key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }
}
