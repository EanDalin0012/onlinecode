package com.onlinecode.webs.api;

import com.onlinecode.utils.SystemDateUtil;
import org.glassfish.jaxb.core.v2.TODO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/web/v1")
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

    @GetMapping(value = "/date")
    public String date() {
        try {
            System.out.println(SystemDateUtil.getDateFormat("yyyyMMdd hhmmss"));
            RestTemplate restTemplate = new RestTemplate();
            String uri = "https://cems.mlvt.gov.kh/oauth/token";

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


            Map<String, Object> data = new LinkedHashMap<>();
            data.put("grant_type", "password");
            data.put("client_id", "8");
            data.put("client_secret", "ndlriNsndLGTZl90m7YNAxQQVaQr6IUbEELzZ1Mn");
            data.put("username", "api@cems.mlvt.gov.kh");
            data.put("password", "System@Hiso%");
            data.put("scope", "ndlriNsndLGTZl90m7YNAxQQVaQr6IUbEELzZ1Mn");
            HttpEntity<Map> entity = new HttpEntity<Map>(data, headers);
            ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Map.class);
            System.out.println(result);

            return result.toString();
        }catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
