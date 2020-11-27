package com.onlinecode.admins.api;

import com.onlinecode.admins.dao.UserDetailsDao;
import com.onlinecode.admins.services.CardIdentifyService;
import com.onlinecode.admins.services.UserInfoService;
import com.onlinecode.admins.services.implement.AccountServiceImplement;
import com.onlinecode.admins.services.implement.CardIdentifyServiceImplement;
import com.onlinecode.admins.services.implement.UserInfoServiceImplement;
import com.onlinecode.admins.utils.MessageUtils;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import com.onlinecode.utils.Uuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user_info/v1")
public class UserInfoAPI {
    private static final Logger log = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    private CardIdentifyServiceImplement cardIdentifyService;
    @Autowired
    private UserInfoServiceImplement userInfoService;
    @Autowired
    private AccountServiceImplement accountService;
    @Autowired
    private UserDetailsDao userDetailsDao;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping(value = "/")
    public ResponseData<MultiMap> index() {
        ResponseData<MultiMap> multiMapResponseData = new ResponseData<>();

        return  multiMapResponseData;
    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            MMap userInfo = param.getMMap("personalInfo");
            MMap cardIdentify = param.getMMap("cardIdentify");
            MMap accountInfo = param.getMMap("accountInfo");

            int userSave            = 0;
            int cardIdentifySave    = 0;
            int accountServiceSave  = 0;
            String user_info_id     = "";
            String cardIdentifyId   = "";
            String accountInfoId    = "";

            try {
                MMap userInfoInput = new MMap();
                user_info_id = Uuid.randomUUID();
                userInfoInput.setString("id",                user_info_id);
                userInfoInput.setString("first_name",        userInfo.getString("first_name"));
                userInfoInput.setString("last_name",         userInfo.getString("last_name"));
                userInfoInput.setString("gender",            userInfo.getString("gender"));
                userInfoInput.setString("date_birth",        userInfo.getString("date_birth"));
                userInfoInput.setString("email",             userInfo.getString("email"));
                userInfoInput.setString("contact",           userInfo.getString("contact"));
                userInfoInput.setString("description",       userInfo.getString("description"));
                userInfoInput.setString("profile_id_image",  userInfo.getString("profile_id_image"));
                userInfoInput.setInt("user_id",              user_id);
                userInfoInput.setString("status",           Status.Active.getValueStr());
                userSave = userInfoService.save(userInfoInput);
            }catch (ValidatorException e1) {
                Message message = MessageUtils.message("user_info_"+e1.getKey(), lang);
                responseData.setError(message);
            }
            try {
                MMap cardIdentifyInput = new MMap();
                cardIdentifyId = Uuid.randomUUID();
                cardIdentifyInput.setString("id",            cardIdentifyId);
                cardIdentifyInput.setString("card_id",       cardIdentify.getString("card_id"));
                cardIdentifyInput.setString("font_image_id", cardIdentify.getString("font_image_id"));
                cardIdentifyInput.setString("rear_image_id", cardIdentify.getString("rear_image_id"));
                cardIdentifyInput.setString("status",        Status.Active.getValueStr());
                cardIdentifyInput.setInt("user_id",              user_id);
                cardIdentifySave = cardIdentifyService.save(cardIdentify);

            }catch (ValidatorException e2 ) {
                Message message = MessageUtils.message("card_identify_"+e2.getKey(), lang);
                responseData.setError(message);
            }
            try{
                MMap accountInfoInput = new MMap();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String password = accountInfo.getString("pw");
                String enCodePasswd = passwordEncoder.encode(password);

                accountInfoId = Uuid.randomUUID();
                accountInfoInput.setString("id",                    accountInfoId);
                accountInfoInput.setString("user_name",             accountInfo.getString("user_name"));
                accountInfoInput.setString("passwd",                enCodePasswd);
                accountInfoInput.setBoolean("is_first_login",       accountInfo.getBoolean("is_first_login"));
                accountInfoInput.setBoolean("enable",               accountInfo.getBoolean("enable"));
                accountInfoInput.setBoolean("account_lock",         accountInfo.getBoolean("account_lock"));
                accountInfoInput.setBoolean("credential_expired",   accountInfo.getBoolean("credential_expired"));
                accountInfoInput.setBoolean("account_expired",      accountInfo.getBoolean("account_expired"));
                accountInfoInput.setString("status",                Status.Active.getValueStr());
                accountInfoInput.setInt("user_id",                  user_id);

                accountServiceSave = accountService.save(accountInfoInput);

            }catch (ValidatorException e3) {
                Message message = MessageUtils.message("card_identify_"+e3.getKey(), lang);
                responseData.setError(message);
            }
            if (userSave > 0 && cardIdentifySave> 0 && accountServiceSave> 0) {
                Long save = saveUserDetails(cardIdentifyId,user_info_id,accountInfoId);
                if (save > 0) {
                    transactionManager.commit(transactionStatus);
                }
            } else {
                transactionManager.rollback(transactionStatus);
            }
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            log.error("get error", e);
            e.printStackTrace();
            Message message = MessageUtils.message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
        }
        return responseData;
    }

    private ResponseData<MMap> executeSave(MMap param) {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {

        }catch (Exception e) {

        }
        String user_info_id = Uuid.randomUUID();

        return responseData;
    }

    private Long saveUserDetails(String card_identify_id,String user_info_id,String user_id) {
        MMap input = new MMap();
        input.setString("card_identify_id", card_identify_id);
        input.setString("user_info_id", user_info_id);
        input.setString("user_id", user_id);
        Long save = userDetailsDao.save(input);
        return save;
    }

}
