package com.onlinecode.core.encryption;

public class Testing {
    public static void main(String[] args){
        try{
            String amount ="20";
            String[] arr = amount.split("\\.");
            String a = arr[0];
            String b = arr[1];
            System.out.println(arr[0]+","+b);
        }catch (Exception e) {
            throw e;
        }
    }
}
