package com.bizcode.admins.api;

import com.bizcode.admins.services.Service;
import com.bizcode.admins.services.implement.UserAccountServiceImplement;
import com.bizcode.constants.Status;
import com.bizcode.core.map.MMap;
import com.bizcode.core.template.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/api/user/account")
public class UserAccountAPI {
    private static final Logger log = LoggerFactory.getLogger(UserAccountAPI.class);
    @Autowired
    private UserAccountServiceImplement userAccountService;

    @PostMapping(value = "/update")
    public ResponseEntity<ResponseData<MMap, MMap>> updateUserAccount(@RequestBody MMap param) throws Exception{
        ResponseData<MMap, MMap> response = new ResponseData<>();
        try {
            MMap header = param.getMMap("header");
            MMap body   = param.getMMap("body");
            MMap resp   = new MMap();
            MMap input  = new MMap();

            input.setInt("userID",                  header.getInt("userID")                 );
            input.setBoolean("enabled",              body.getBoolean("enabled")               );
            input.setBoolean("accountLocked",         body.getBoolean("accountLocked")          );
            input.setBoolean("accountExpired",      body.getBoolean("accountExpired")       );
            input.setBoolean("credentialsExpired",  body.getBoolean("credentialsExpired")   );
            input.setString("status",               Status.Modify.getValueStr()                  );
            input.setString("userName",             body.getString("userName")              );
            input.setInt("id",                      body.getInt("id")                       );
            String isSuccess = "N";

            int update = userAccountService.updateUserAccount(input);
            if (update > 0 ) {
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

}

