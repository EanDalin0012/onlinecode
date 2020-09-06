package com.bizcode.mobiles.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mobile")
public class MobileAPI {
    @GetMapping(value = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("api mobile", HttpStatus.OK);
    }
}
