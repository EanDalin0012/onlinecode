package com.onlinecode.core.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testing {
    public static void main(String[] args){
        try{
            String amount ="20.22";
            String[] arr = amount.split("\\.");
            String a = arr[0];
            String b = arr[1];
            System.out.println(arr[0]+","+b);

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String _password = "$2a$10$nj4x5nWUlMlLTzvGK9pUvONEUTdoMLGXtVnR/BSAXKyH.kcWXZSh6";
            String password = "admin123";
            boolean isPasswordMatch = passwordEncoder.matches(password, _password);
            System.out.println(isPasswordMatch);
            System.out.println(passwordEncoder.encode("@min1234"));

        }catch (Exception e) {
            throw e;
        }
    }
}
