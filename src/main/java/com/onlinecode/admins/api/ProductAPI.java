package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.ProductServiceImplement;
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
@RequestMapping(value = "/api/product")
public class ProductAPI {

    private static final Logger log = LoggerFactory.getLogger(ProductAPI.class);
    @Autowired
    private ProductServiceImplement productService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/list")
    public ResponseData<MultiMap> list() throws Exception {
        return getProductList();
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
            input.setString("description", param.getString("description"));
            input.setString("status", Status.Active.getValueStr());
            input.setInt("resource_img_id", param.getInt("resource_img_id"));


            if (function == "save") {
                int id = productService.sequence();
                input.setInt("id",          id);
                Long save = productService.save(input);
                if (save > 0 ) {
                    out.setString("status", "Y");
                }

            } else if (function == "update") {
                input.setInt("id",          param.getInt("id"));
                Long update = productService.update(input);
                if (update > 0) {
                    out.setString("status", "Y");
                }
            }

            responseData.setBody(out);

            log.info("\n\n<<<===****Product response : "+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End product "+function+" api***====>>>\n\n");
        }catch (Exception e) {
            log.error("******====get error api "+function+" product", e);
            throw e;
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
                    productService.delete(input);
                }

                transactionManager.commit(transactionStatus);
                out.setString("status", "Y");
                responseData.setBody(out);
            }
            log.info("\n\n***End");
        }catch (Exception e) {
            log.error("******====get error api delete product", e);
            throw e;
        }
        return responseData;
    }

    private  ResponseData<MultiMap> getProductList() throws Exception {
        ResponseData<MultiMap> responseData = new ResponseData<>();
        try {
            log.info("\n\n<<<===****Start Product get list***====>>>\n\n");

            MMap input = new MMap();
            input.setString("status", Status.Delete.getValueStr());

            MultiMap responseBody = productService.retrieveList(input);
            responseData.setBody(responseBody);

            log.info("\n\n<<<===****Product list value:"+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End Product get list***====>>>\n\n");

        } catch (Exception e) {
            log.error("\n<<<=====get error api Product get list=====>>>",e);
            throw  e;
        }
        return responseData;
    }

}
