package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.CardIdentifyServiceImplement;
import com.onlinecode.admins.utils.MessageUtils;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.ReturnStatus;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.template.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/card-identify/v1")
public class CardIdentifyAPI {
    private static final Logger log = LoggerFactory.getLogger(CardIdentifyAPI.class);

    @Autowired
    private CardIdentifyServiceImplement cardIdentifyService;

    @PostMapping(value = "/id")
    public ResponseData<MMap> retrieveCardIdentifyById(@RequestBody MMap param, @RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        ResponseData<MMap> responseData = new ResponseData<>();
        MMap out = new MMap();

        try {
            MMap body = param.getMMap("body");
            MMap input = new MMap();
            input.setString("card_id", body.getString("card_id"));
            MMap data = cardIdentifyService.retrieveCardIdentifyById(input);
            log.info("Retrieve Card Identify By Id Data:", data);
            responseData.setBody(data);
            out.setString("status", ReturnStatus.Y);
            return responseData;
        } catch (ValidatorException ex) {
            log.error("get error api /api/card-identify", ex);
            Message message = MessageUtils.message("card_identify_"+ex.getKey(), lang);
            responseData.setError(message);
            return responseData;
        }
        catch (Exception e) {
            log.error("get error api /api/card-identify", e);
            Message message = MessageUtils.message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
            return responseData;
        }

    }
}
