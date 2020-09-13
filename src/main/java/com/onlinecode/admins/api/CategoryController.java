package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.CategoryServiceImplement;
import com.onlinecode.constants.Status;
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
    public ResponseData<MultiMap> list() throws Exception {
        ResponseData<MultiMap> response = new ResponseData<>();
        try {
            log.info("\n\n <<<<=====******Start get list of category******=====>>>\n");

            MMap input = new MMap();
            input.setString("status", Status.Active.getValueStr());

            MultiMap out    = categoryService.retrieveList(input);
            response.setBody(out);

            log.info("\n\n <<<<=====******result : "+response+"******=====>>>\n");
            log.info("\n\n <<<<=====******End get list of category******=====>>>\n\n");

        } catch (Exception e) {
            log.error("get error exception of api category get list error",e);
            throw e;
        }
        return response;
    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            log.info("\n\n<<<=====*******Start save category********====>>>\n\n");
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
        } catch (Exception e) {
            log.error("get error exception of category api save",e);
            throw e;
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

        } catch (Exception e) {
            log.error("\n<<<<<<<========get error api category update", e);
            throw e;
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

        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            log.error("get error exception category delete:",e);
            throw e;
        }
        return responseData;
    }
}
