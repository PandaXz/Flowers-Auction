package com.belykh.finalProj.util;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by panda on 16.11.17.
 */
public class MD5Util {
    private static MD5Util ourInstance = new MD5Util();


    private MD5Util() {
    }

    
    public static MD5Util getInstance() {
        return ourInstance;
    }

    public String getMD5Hash(String data) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            hash = DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to MD5 encode.", e);
        }

        return hash;
    }
}
