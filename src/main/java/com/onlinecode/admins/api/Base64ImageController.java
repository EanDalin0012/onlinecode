package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.ResourceImageServiceImplement;
import com.onlinecode.admins.utils.Base64ImageUtil;
import com.onlinecode.component.Translator;
import com.onlinecode.constants.ErrorCode;
import com.onlinecode.constants.Status;
import com.onlinecode.core.dto.Message;
import com.onlinecode.core.exception.ValidatorException;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.template.ResponseData;
import com.onlinecode.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/base64/image")
public class Base64ImageController {
    private static final Logger log = LoggerFactory.getLogger(Base64ImageController.class);
    @Autowired
    private ResourceImageServiceImplement resourceImageService;

    @PostMapping(value = "/write")
    public ResponseData<MMap> index(@RequestBody MMap param, @RequestParam("userId") int user_id, @RequestParam("lang") String lang) {
        ResponseData<MMap> responseData = new ResponseData<>();
        MMap output = new MMap();
        try {
            log.info("================Start write image=============");

            MMap body  = param.getMMap("body");
            log.info("param:",body);
            MMap input = new MMap();

            output.setString("status", "N");

            String path          = "/uploads/products";
            String base64        = body.getString("base64");
            String id            = body.getString("id");
            String fileExtension = body.getString("file_extension");

            log.info("path:"+path+",id"+id+",name:"+id+",extension:"+fileExtension);
            log.info("base64:"+base64);

            String basePath      = Base64ImageUtil.decodeToImage(path, base64, id, fileExtension);

            if (!basePath.equals("")) {
                log.info("data:"+input);
                input.setString("id",               id);
                input.setString("file_name",        id);
                input.setInt("file_size",           body.getInt("file_size"));
                input.setString("file_type",        body.getString("file_type"));
                input.setString("file_extension",   body.getString("file_extension"));
                input.setString("original_name",    body.getString("file_name"));
                input.setString("file_source",      basePath);
                input.setString("status",           Status.Active.getValueStr());
                input.setInt("user_id",             user_id);
               Long save = resourceImageService.save(input);
               if (save > 0) {
                   output.setString("status", "Y");
               }
            } else  {
                log.info("can not write image");
                Message message = message(ErrorCode.EXCEPTION_ERR, lang);
                responseData.setError(message);
            }

        }catch (ValidatorException ex) {
            log.info("Wrong validation", ex);
            Message message = message(ex.getKey(), lang);
            responseData.setError(message);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("error Exception api category get list", e);
            Message message = message(ErrorCode.EXCEPTION_ERR, lang);
            responseData.setError(message);
        }
        responseData.setBody(output);
        return responseData;
    }

    @PostMapping(value = "/delete")
    public ResponseData<MMap> delete() {
        ResponseData<MMap> responseData = new ResponseData<>();
        try{

        }catch (Exception e) {
            throw e;
        }
        return  responseData;
    }
    @GetMapping("/read/{resource_id}")
    public String  resourcesImage(@PathVariable("resource_id") String resource_id) {
        String base64 = "dd";
        log.info("========Start api base64 img====");
        try {
            log.info("====resource_id ======"+resource_id);
            MMap input = new MMap();
            input.setString("uuid", resource_id);
            String path = resourceImageService.getResourcesImageById(input);
            log.info("===path:"+path);
            String fullpath  = SystemUtil.projectPath() + path;
            base64 = Base64ImageUtil.encoder(fullpath);

        } catch (ValidatorException ex) {
            ex.printStackTrace();
        }catch (Exception e) {
            throw e;
        }

        return  base64;
    }

    private Message message(String key, String lang) {
        Message data = new Message();
        String message = Translator.toLocale(lang, "image_"+key);
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
