package com.example.demo.util;

import java.security.*;

import org.springframework.context.annotation.Configuration;

public class SecurityUtil {
    
    public static String encryptSHA256(String str) {

        String sha = "";

        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString(byteData[i] & 0xff + 0x100, 16).substring(1));
            }
            sha = sb.toString();
        } catch(Exception e) {
            sha = null;
            System.out.println(e);
        }
        return sha;
    }
}
