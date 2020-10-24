package com.onlinecode.mobiles.api;

import com.onlinecode.admins.api.FileRestController;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.template.ResponseData;
import com.onlinecode.utils.SystemUtil;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/mobile")
public class MobileAPI {
    private static final Logger log = LoggerFactory.getLogger(MobileAPI.class);
    @PostMapping(value = "/")
    public ResponseEntity<String> index(@RequestBody String data) throws IOException {
        try
        {
            String imageValue = "";
            log.info(data);
            //This will decode the String which is encoded by using Base64 class
            byte[] imageByte= Base64.decodeBase64(data);
            String directory= SystemUtil.path()+"/products";
            new FileOutputStream(directory).write(imageByte);
        }
        catch(Exception e)
        {
            throw e;
        }
        return new ResponseEntity<>("api mobile", HttpStatus.OK);
    }


    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile multipartFile,
                                                               @RequestParam("fileImageURL") String fileImageURL,
                                                               @RequestParam("userID") String userID) throws Exception {
        ResponseData<MMap> response = new ResponseData<>();
        InputStream is = null;

        log.info("======Start file upload=====");
    }
}
