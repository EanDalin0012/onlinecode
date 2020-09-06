package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.UserAccountServiceImplement;
import com.onlinecode.admins.utils.DefaultResponse;
import com.onlinecode.constants.Status;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
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
    public ResponseEntity<ResponseData<MMap, MMap>> updateUserAccount(@RequestBody MMap param) throws Exception {
        ResponseData<MMap, MMap> response = new ResponseData<>();
        try {
            MMap header = param.getMMap("header");
            MMap body = param.getMMap("body");
            MMap resp = new MMap();
            MMap input = new MMap();

            input.setInt("userID", header.getInt("userID"));
            input.setBoolean("enabled", body.getBoolean("enabled"));
            input.setBoolean("accountLocked", body.getBoolean("accountLocked"));
            input.setBoolean("accountExpired", body.getBoolean("accountExpired"));
            input.setBoolean("credentialsExpired", body.getBoolean("credentialsExpired"));
            input.setString("status", Status.Modify.getValueStr());
            input.setString("userName", body.getString("userName"));
            input.setInt("id", body.getInt("id"));
            String isSuccess = "N";

            int update = userAccountService.updateUserAccount(input);
            if (update > 0) {
                isSuccess = "Y";
                resp.setString("isSuccessYN", isSuccess);
            }
            response.setHeader(header);
            response.setBody(resp);
        } catch (Exception e) {
            log.error("get error exception api usr account update e:", e);
            throw e;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * <pre>
     *     get list of user
     * </pre>
     *
     * @param <pre> header: { msg: string,
     *              sessionId: string,
     *              authData: string,
     *              userID: int,
     *              languageCode: string,
     *              channelTypeCode: string,
     *              result: boolean
     *              }
     *              body: {}
     *              </pre>
     * @return
     */
    @GetMapping(value = "/list")
    public ResponseEntity<ResponseData<MMap, MMap>> getUserList() throws Exception {
        ResponseData<MMap, MMap> responseData = new ResponseData<>();
        try {
            MMap header = DefaultResponse.defaultHeader();
            ;
            MMap input = new MMap();
            MMap output = new MMap();
            MMap body = new MMap();

            input.setString("status", Status.Delete.getValueStr());
            MultiMap userList = userAccountService.getList(input);

            int count = userAccountService.count();
            body.setMultiMap("items", userList);
            body.setInt("totalRecords", count);
            output.setMMap("header", header);

            responseData.setBody(body);
            responseData.setHeader(header);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

}

