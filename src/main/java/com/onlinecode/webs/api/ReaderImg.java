package com.onlinecode.webs.api;

import com.onlinecode.admins.utils.Base64ImageUtil;
import com.onlinecode.core.map.MMap;
import com.onlinecode.utils.SystemUtil;
import com.onlinecode.webs.service.imp.ReaderImgServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/web/reader")
public class ReaderImg {
    @Autowired
    private ReaderImgServiceImp readerImgServiceImp;

    @GetMapping(value = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("api webs", HttpStatus.OK);
    }

    @GetMapping("/read/{resource_id}")
    public String  resourcesImage(@PathVariable("resource_id") String resource_id) {
        try {
            String data = "";
            MMap input = new MMap();
            input.setString("id", resource_id);
            String path = readerImgServiceImp.getResourcesImageById(input);
            String fullpath  = SystemUtil.projectPath() + path;
            data=  Base64ImageUtil.encoder(fullpath);
            return data;
        }catch (Exception e) {
            throw e;
        }
    }

}
