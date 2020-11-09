package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.UserServiceImplement;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.ReturnStatus;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.encryption.AESUtils;
import com.onlinecode.core.exception.ApplicationException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import com.onlinecode.utils.ValidatorUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/user")
public class UserAPI {
    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private UserServiceImplement userService;
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private TokenStore tokenStore;

    /**
     * <pre>
     *     get list of user
     * </pre>
     *
     * @param
     * @return
     */
    @GetMapping(value = "/get/list")
    public ResponseEntity<ResponseData<MMap>> getUserList() throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            MMap input = new MMap();
            MMap body = new MMap();

            input.setString("status", Status.Delete.getValueStr());
            MultiMap userList = userService.getList(input);

            int count = userService.count();
            body.setMultiMap("items", userList);
            body.setInt("totalRecords", count);

            responseData.setBody(body);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <pre>
     *     save information of user
     * </pre>
     *
     * @param param <pre>
     *                  header:
     *                  body: {
     *                       firstName: String,
     *                	    lastName: String,
     *                	    dateBirth: String,
     *                	    email: String,
     *                	    password: String,
     *                	    contact: String
     *                	    gender: String,
     *                	    description: String,
     *                	    addressID: int,
     *                	    resourceID: int
     *                  }
     *              </pre>
     * @return
     * @throws
     **/
    @PostMapping(value = "/save")
    public ResponseEntity<ResponseData<MMap>> save(@RequestBody MMap param) throws Exception {
        return execute(param, "save");
    }

    @GetMapping(value = "/oauth/revoke-token")
    public ResponseData<MMap> oauthRevokeToken(HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        MMap output = new MMap();
        try {
            output.setString(ReturnStatus.StatusProperty, ReturnStatus.N);
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null) {
                String tokenValue = authHeader.replace("Bearer", "").trim();
                OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
                tokenStore.removeAccessToken(accessToken);
                output.setString(ReturnStatus.StatusProperty, ReturnStatus.Y);
            }
            responseData.setBody(output);
        }catch (Exception e) {
            Message message = message(ErrorCode.EXCEPTION_ERR, "en");
            responseData.setError(message);
            return responseData;
        }
        return  responseData;
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
    private ResponseEntity<ResponseData<MMap>> execute(MMap param, String function) throws Exception {
        ResponseData<MMap> response = new ResponseData<>();
        MMap getHeader = param.getMMap("header");
        MMap body = param.getMMap("body");
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            MMap input = new MMap();
            MMap responseBody = new MMap();
            String Yn = "N";

            ValidatorUtil.validate(body, "firstName", "lastName", "dateBirth", "email", "password", "contact", "gender");

            input.setString("firstName", body.getString("firstName"));
            input.setString("lastName", body.getString("lastName"));
            input.setString("dateBirth", body.getString("dateBirth"));
            input.setString("email", body.getString("email"));
            input.setString("password", body.getString("password"));
            input.setString("contact", body.getString("contact"));
            input.setString("gender", body.getString("gender"));
            input.setString("description", body.getString("description"));
            input.setInt("addressID", body.getInt("addressID"));
            input.setInt("resourceID", body.getInt("resourceID"));
            input.setInt("userID", getHeader.getInt("userID"));

            if (function == "save") {
                input.setString("status", Status.Active.getValueStr());
                int save = userService.save(input);
                if (save > 0) {
                    Yn = "Y";
                }
            }
            if (function == "update") {
                input.setLong("id", body.getLong("id"));
                input.setString("status", Status.Modify.getValueStr());
                int update = userService.update(input);
                if (update > 0) {
                    Yn = "Y";
                }
            }

            transactionManager.commit(transactionStatus);
            responseBody.setString("returnYN", Yn);
            response.setBody(responseBody);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            log.error("get Exception ", e);
            throw e;
        }
    }

    @GetMapping(value = "/load_user")
    public ResponseEntity<ResponseData<MMap>> getUserByUserName(@RequestParam("userName") String userName) throws  Exception {
        ResponseData<MMap> out = new ResponseData<>();
        try {

            log.info("\n\n<<<<====***user api loader user param: [" + userName + "]***====>>>> \n");
            if (userName == null || userName == "") {
                throw new Exception("user name is null");
            }

            MMap input = new MMap();
            MMap outPut = new MMap();
            MMap header = new MMap();
            header.setBoolean("result", true);
            header.setString("mgs", "test");

            input.setString("userName", userName);

            outPut = userService.loadUserByUserName(input);
            log.info("\n\n<<<<====***user api loader user out put : " + outPut + "***====>>>> \n");
            out.setBody(outPut);
        }catch (Exception e) {
            log.error("load user by user name get exception error:", e);
            throw e;
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "user_"+key);
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
