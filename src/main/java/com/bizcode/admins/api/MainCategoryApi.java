package com.bizcode.admins.api;

import com.bizcode.admins.services.implement.MainCategoryServiceImplement;
import com.bizcode.admins.utils.DefaultResponse;
import com.bizcode.constants.Status;
import com.bizcode.core.map.MMap;
import com.bizcode.core.map.MultiMap;
import com.bizcode.core.template.ResponseData;
import com.bizcode.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/main/category")
public class MainCategoryApi {
    private static final Logger log = LoggerFactory.getLogger(CompanyAPI.class);
    @Autowired
    private MainCategoryServiceImplement categoryService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/get/list")
    public ResponseEntity<ResponseData<MMap, MultiMap>> retrieveCategoryList() throws Exception {
        ResponseData<MMap, MultiMap> _response = new ResponseData<>();
        try {
            MMap input = new MMap();
            input.setString("status", Status.Delete.getValueStr());
            MultiMap out = categoryService.retrieveList(input);

            MMap header = new MMap();
            header = DefaultResponse.defaultHeader();
            _response.setHeader(header);
            _response.setBody(out);

        } catch (Exception e) {
            log.error("api category retrieve category list get error exception:", e);
            throw e;
        }
        return new ResponseEntity<>(_response, HttpStatus.OK);
    }

    /**
     * <pre>
     *     save information of main category
     * </pre>
     *
     * @param <pre> id(require): main category id
     *              name(require): main category name
     *              description(optional): description
     *              </pre>
     * @return
     * @throws
     */
    @PostMapping(value = "/update")
    public ResponseEntity<ResponseData<MMap, MMap>> update(@RequestBody MMap param) throws Exception {
        return execute(param, "update");
    }

    /**
     * <pre>
     *     save information of main category
     * </pre>
     *
     * @param <pre> name(require): main category name
     *              description(optional): description
     *              </pre>
     * @return
     * @throws
     */
    @PostMapping(value = "/save")
    public ResponseEntity<ResponseData<MMap, MMap>> save(@RequestBody MMap param) throws Exception {
        return execute(param, "save");
    }

    /**
     * <pre>
     *     register or update information of main category
     * </pre>
     *
     * @param param
     * @param function
     * @return ResponseEntity<MMap>
     * @throws Exception
     */
    private ResponseEntity<ResponseData<MMap, MMap>> execute(MMap param, String function) throws Exception {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        MMap getHeader = param.getMMap("header");
        MMap body = param.getMMap("body");
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            MMap input = new MMap();
            MMap responseBody = new MMap();

            ValidatorUtil.validate(body, "name");

            input.setString("name", body.getString("name"));
            input.setLong("userID", getHeader.getLong("userID"));
            input.setString("description", body.getString("description"));
            // Long isSuccess;
            if (function == "save") {
                input.setString("status", Status.Active.getValueStr());
                categoryService.save(input);
            } else if (function == "update") {
                input.setLong("id", body.getLong("id"));
                input.setString("status", Status.Modify.getValueStr());
                categoryService.update(input);
            }

            transactionManager.commit(transactionStatus);
            response.setHeader(DefaultResponse.defaultHeader());
            response.setBody(DefaultResponse.defaultBody());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            log.error("get Exception ", e);
            throw e;
        }
    }


    @PostMapping(value = "/delete")
    public ResponseEntity<ResponseData<MMap, MMap>> delete(@RequestBody MMap param) {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        try {
            MMap header = param.getMMap("header");
            MMap body = param.getMMap("body");

        } catch (Exception e) {
            log.error("get error exception api main category delete:", e);
            throw e;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
