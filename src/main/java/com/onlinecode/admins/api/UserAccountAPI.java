package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.UserAccountServiceImplement;
import com.onlinecode.admins.utils.DefaultResponse;
import com.onlinecode.admins.utils.MessageUtils;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.ReturnStatus;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import org.apache.ibatis.annotations.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user/account")
public class UserAccountAPI {
    private static final Logger log = LoggerFactory.getLogger(UserAccountAPI.class);
    @Autowired
    private UserAccountServiceImplement userAccountService;

    @PostMapping(value = "/update")
    public ResponseEntity<ResponseData<MMap>> updateUserAccount(@RequestParam("userId") int user_id, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> response = new ResponseData<>();
        try {
            log.info("\n<<<<====Start update user account api param:["+param+"]\n");
            MMap body = param.getMMap("body");
            MMap resp = new MMap();
            MMap input = new MMap();

            input.setInt("userID", user_id);
            input.setBoolean("enabled", body.getBoolean("enabled"));
            input.setBoolean("accountLocked", body.getBoolean("accountLocked"));
            input.setBoolean("accountExpired", body.getBoolean("accountExpired"));
            input.setBoolean("credentialsExpired", body.getBoolean("credentialsExpired"));
            input.setString("status", Status.Modify.getValueStr());
            input.setString("userName", body.getString("userName"));
            input.setInt("id", body.getInt("id"));

            log.info("\n<<<<==== update user account api input:["+input+"]\n");
            String isSuccess = "N";

            int update = userAccountService.updateUserAccount(input);
            if (update > 0) {
                isSuccess = "Y";
                resp.setString("isSuccessYN", isSuccess);
                log.info("\n<<<<====update user account api success\n");
            }
            response.setBody(resp);
        } catch (Exception e) {
            log.error("get error exception api usr account update e:", e);
            throw e;
        }
        log.info("\n<<<<====End update user account api===>>>>\n");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * <pre>
     *     get list of user
     * </pre>
     *
     * @param
     * @return
     */
    @GetMapping(value = "/list")
    public ResponseEntity<ResponseData<MMap>> getUserList() throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            log.info("\n<<<<====Start get list user account api:\n");
            MMap input = new MMap();
            MMap body = new MMap();

            input.setString("status", Status.Delete.getValueStr());
            log.info("\n<<<<==== get list user account api input: "+ input);
            MultiMap userList = userAccountService.getList(input);

            int count = userAccountService.count();
            body.setMultiMap("items", userList);
            body.setInt("totalRecords", count);

            responseData.setBody(body);

            log.info("<<<<====End get list user account api return value:\n"+responseData+"\n");
            log.info("\n<<<<====End get list user account api:\n");

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping(value = "/account_id")
    public ResponseData<MMap> retrieveUserById(@RequestBody MMap param, @RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        ResponseData<MMap> responseData = new ResponseData<>();
        MMap out = new MMap();

        try {
            MMap body = param.getMMap("body");
            MMap input = new MMap();
            input.setInt("id", body.getInt("account_id"));
            MMap data = userAccountService.retrieveUserAccountByID(input);
            log.info("Retrieve User Account By Id Data:", data);
            responseData.setBody(data);
            out.setString("status", ReturnStatus.Y);
            return responseData;
        } catch (ValidatorException ex) {
            log.error("get error api retrieveUserById", ex);
            Message message = MessageUtils.message("account_"+ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        }
        catch (Exception e) {
            log.error("get error api retrieveUserById", e);
            Message message = MessageUtils.message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }

    }

}

