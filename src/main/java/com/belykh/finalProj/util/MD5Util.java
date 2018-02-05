package com.belykh.finalProj.util;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO: Auto-generated Javadoc
/**
 * The Class MD5Util.
 */
public class MD5Util {
    private static MD5Util instance = new MD5Util();


    private MD5Util() {
    }

    
    /**
     * Gets the single instance of MD5Util.
     *
     * @return single instance of MD5Util
     */
    public static MD5Util getInstance() {
        return instance;
    }

    /**
     * Gets the MD 5 hash.
     *
     * @param data the data
     * @return the MD 5 hash
     */
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
