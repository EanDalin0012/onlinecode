package com.onlinecode;

import com.onlinecode.core.encryption.AESUtils;
import com.onlinecode.core.map.MMap;
import org.codehaus.jackson.map.ObjectMapper;

public class EASUtilTesting {
    public static void main(String[] args) {
        try{
            String key = "admin";
            MMap data = new MMap();
            data.setString("id", "jdaklf");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(data);
            String encryptedData = AESUtils.encrypt(key, jsonString);
            String decrtyptedData = AESUtils.decrypt(encryptedData, key);

            System.out.println("encrypt data:\n"+encryptedData);
            System.out.println("decrypted data:\n"+decrtyptedData);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
