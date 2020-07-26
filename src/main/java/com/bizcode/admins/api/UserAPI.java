package com.bizcode.admins.api;

import com.bizcode.admins.services.implement.UserServiceImplement;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserAPI {
    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private UserServiceImplement userService;
    @Autowired
    private PlatformTransactionManager transactionManager;

    // private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * <pre>
     *     get list of user
     * </pre>
     * @param param
     * <pre>
     *     header: { msg: string,
     *              sessionId: string,
     *              authData: string,
     *              userID: int,
     *              languageCode: string,
     *              channelTypeCode: string,
     *              result: boolean
     *              }
     *     body: {}
     * </pre>
     * @return
     * */
    @PostMapping(value = "/get/list")
    public ResponseEntity<ResponseData<MMap, MMap>> getUserList(@RequestBody MMap param) throws Exception {
        ResponseData<MMap, MMap> responseData = new ResponseData<>();
        try {
            MMap header = param.getMMap("header");
            MMap input  = new MMap();
            input.setString("status", Status.Delete.getValueStr());
            MultiMap userList = userService.getList(input);
            int count = userService.count();
            MMap output = new MMap();
            output.setMultiMap("list", userList);
            output.setLong("totalRecord", count);
            responseData.setBody(output);
            responseData.setHeader(header);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     * <pre>
     *     save information of user
     * </pre>
     * @param param
     * <pre>
     *     header:
     *     body: {
     *          firstName: String,
     *   	    lastName: String,
     *   	    dateBirth: String,
     *   	    email: String,
     *   	    password: String,
     *   	    contact: String
     *   	    gender: String,
     *   	    description: String,
     *   	    addressID: int,
     *   	    resourceID: int
     *     }
     * </pre>
     * @return
     * @throws
     **/
    @PostMapping(value = "/save")
    public ResponseEntity<ResponseData<MMap, MMap>> save(@RequestBody MMap param) throws Exception {
        return execute(param, "save");
    }

    /**
     * <pre>
     *     register or update information of main category
     * </pre>
     * @param param
     * @param  function
     * @return ResponseEntity<MMap>
     * @throws Exception
     * */
    private ResponseEntity<ResponseData<MMap, MMap>> execute(MMap param, String function) throws Exception {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        MMap getHeader  = param.getMMap("header");
        MMap body       = param.getMMap("body");
        TransactionStatus transactionStatus    = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            MMap input          = new MMap();
            MMap responseBody   = new MMap();
            String Yn           = "N";

            ValidatorUtil.validate(body, "firstName", "lastName", "dateBirth", "email", "password", "contact", "gender");

            input.setString("firstName"     , body.getString("firstName"    ));
            input.setString("lastName"      , body.getString("lastName"       ));
            input.setString("dateBirth"     , body.getString("dateBirth"    ));
            input.setString("email"         , body.getString("email"           ));
            input.setString("password"      , body.getString("password"     ));
            input.setString("contact"       , body.getString("contact"      ));
            input.setString("gender"        , body.getString("gender"       ));
            input.setString("description"   , body.getString("description"  ));
            input.setInt("addressID"        , body.getInt("addressID"    ));
            input.setInt("resourceID"       , body.getInt("resourceID"   ));
            input.setInt("userID"           , getHeader.getInt("userID"     ));

            if (function == "save") {
                input.setString("status",   Status.Active.getValueStr());
                int save = userService.save(input);
                if (save > 0 ) {
                    Yn = "Y";
                }
            }
            if (function == "update") {
                input.setLong("id"  ,     body.getLong("id")  );
                input.setString("status", Status.Modify.getValueStr() );
                int update = userService.update(input);
                if (update > 0 ) {
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

}
