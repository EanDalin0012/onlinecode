package com.bizcode.webs.api;

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
        return new ResponseEntity<>("api webs", HttpStatus.OK);
    }
}
