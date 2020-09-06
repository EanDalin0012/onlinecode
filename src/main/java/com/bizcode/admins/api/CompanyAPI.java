package com.bizcode.admins.api;

import com.bizcode.admins.services.implement.CompanyServiceImplement;
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
@RequestMapping(value = "/api/company")
public class CompanyAPI {
    private static final Logger log = LoggerFactory.getLogger(CompanyAPI.class);

    @Autowired
    private CompanyServiceImplement companyService;
    @Autowired
    private PlatformTransactionManager transactionManager;


    /**
     * <pre>
     *     get list of company
     * </pre>
     *
     * @param param
     * @return
     * @throws
     **/
    @GetMapping(value = "/get/list")
    public ResponseEntity<ResponseData<MMap, MMap>> getList(@RequestParam("lang") String param) {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        MMap header = new MMap();

        try {
            MMap input = new MMap();

            input.setString("status", Status.Delete.getValueStr());
            MultiMap list = companyService.getList(input);
            MMap out = new MMap();
            out.setMultiMap("list", list);

            response.setHeader(header);
            response.setBody(out);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("\n get error api company <<<=== getList() ===>>:\n", e.getMessage());
            throw e;
        }
    }

    /**
     * <pre>
     *     save information of company
     * </pre>
     *
     * @param param
     * @return
     * @throws
     **/
    @PostMapping(value = "/save")
    public ResponseEntity<ResponseData<MMap, MMap>> save(@RequestBody MMap param) throws Exception {
        return execute(param, "save");
    }

    /**
     * <pre>
     *     update information of company
     * </pre>
     *
     * @param param
     * @return ResponseData<MMap, MMap>
     * @throws Exception
     **/
    @PostMapping(value = "/update")
    public ResponseEntity<ResponseData<MMap, MMap>> update(@RequestBody MMap param) throws Exception {
        return execute(param, "update");
    }

    /**
     * <pre>
     *
     * </pre>
     *
     * @param param
     * @functionName delete
     * @description delete main category by id list
     **/
    @PostMapping(value = "/update/status/to/delete")
    public ResponseEntity<ResponseData<MMap, MMap>> delete(@RequestBody MMap param) {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        MMap header = param.getMMap("header");
        MMap body = param.getMMap("body");
        MultiMap list = body.getMultiMap("list");

        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            for (MMap in : list.toListData()) {
                MMap input = new MMap();
                input.setString("status", Status.Delete.getValueStr());
                input.setInt("userID", header.getInt("userID"));
                input.setInt("id", in.getInt("id"));
                System.out.println(input);
                companyService.delete(input);
            }
            MMap resBody = new MMap();
            resBody.setString("returnYN", "Y");

            response.setHeader(header);
            response.setBody(resBody);
            transactionManager.commit(transactionStatus);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("\n get error category get list by Id ===>>>:", e.getMessage());
            transactionManager.rollback(transactionStatus);
            throw e;
        }
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
            String Yn = "N";

            ValidatorUtil.validate(body, "name", "contact", "email");

            input.setString("name", body.getString("name"));
            input.setLong("contact", body.getLong("contact"));
            input.setString("email", body.getString("email"));
            input.setInt("addressID", body.getInt("addressID"));
            input.setString("description", body.getString("description"));
            input.setInt("userID", getHeader.getInt("userID"));

            if (function == "save") {
                input.setString("status", Status.Active.getValueStr());
                Long save = companyService.save(input);
                if (save > 0) {
                    Yn = "Y";
                }
            }
            if (function == "update") {
                input.setLong("id", body.getLong("id"));
                input.setString("status", Status.Modify.getValueStr());
                Long update = companyService.update(input);
                if (update > 0) {
                    Yn = "Y";
                }
            }

            transactionManager.commit(transactionStatus);
            responseBody.setString("returnYN", Yn);
            response.setHeader(getHeader);
            response.setBody(responseBody);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            log.error("get Exception ", e);
            throw e;
        }
    }

    /**
     * <pre>
     *     get value by id
     * </pre>
     *
     * @param param <pre>
     *                   header:
     *                   body: id: int
     *               </pre>
     */
    @PostMapping(value = "/get/value/by/id")
    public ResponseEntity<ResponseData<MMap, MMap>> getValueById(@RequestBody MMap param) throws Exception {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        try {
            MMap header = param.getMMap("header");
            MMap body = param.getMMap("body");
            ValidatorUtil.validate(body, "id");
            MMap input = new MMap();
            input.setInt("id", body.getInt("id"));

            MMap output = companyService.getValueById(input);
            response.setHeader(header);
            response.setBody(output);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("get value by id of company api", e);
            throw new Exception("error input:");
        }

    }
}
