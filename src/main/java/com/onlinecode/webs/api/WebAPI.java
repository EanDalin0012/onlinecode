package com.onlinecode.webs.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/web")
class WebAPI {
    @GetMapping(value = "/")
    public ResponseEntity<String> index() {
        try {
            String amount ="20";
            String[] arr = amount.split("\\.");
            String a = arr[0];
            String b = arr[1];
            System.out.println(arr[0]+","+b);
        }catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>("api webs", HttpStatus.OK);
    }
}
