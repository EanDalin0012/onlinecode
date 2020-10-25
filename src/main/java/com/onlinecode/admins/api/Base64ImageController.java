package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.ResourceImageServiceImplement;
import com.onlinecode.admins.utils.Base64ImageUtil;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/base64/image")
public class Base64ImageController {
    private static final Logger log = LoggerFactory.getLogger(Base64ImageController.class);
    @Autowired
    private ResourceImageServiceImplement resourceImageService;

    @PostMapping(value = "/write")
    public ResponseData<MMap> index(@RequestBody MMap param, @RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            MMap body  = param.getMMap("body");
            MMap input = new MMap();
            String uuid = UUID.randomUUID().toString();
            input.setString("id", uuid);
            String path = "/uploads/Products";
            String base64 = body.getString("file_source");
            String fileName = uuid;
            String fileExtension = body.getString("file_extension");
            String basePath = Base64ImageUtil.decodeToImage(path, base64, fileName, fileExtension);

//            input.setString("file_name", body.getString("file_name"));
//            input.setString("file_type", body.getString("file_type"));
//            input.setInt("file_extension", body.getInt("file_extension"));
//            input.setString("file_source", body.getString("file_source"));
//            input.setString("file_size", body.getString("file_size"));
//            resourceImageService.save(input);



        }
//        catch (ValidatorException ex) {
//
//        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("error Exception api category get list", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
        }
        return responseData;
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "category_"+key);
        if (ErrorCode.EXCEPTION_ERR == key) {
            message = Translator.toLocale(lang, key);
        } else if ("status".equals(key)) {
            message = Translator.toLocale(lang, "status");
        } else if ("user_id".equals(key)) {
            message = Translator.toLocale(lang, "user_id");
        }
        data.setCode(key);
        data.setMessage(message);
        return data;
    }

}
