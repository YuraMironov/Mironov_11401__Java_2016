package ru.kpfu.itis.Mironov.SE.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Юра on 04.05.2016.
 */
public class MD5{
        static String md5Decoder(String password) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(password.getBytes(), 0, password.length());
            String pass = new BigInteger(1, messageDigest.digest()).toString(16);
            if (pass.length() < 32) {
                pass = "0" + pass;
            }
            return pass;
        }
}
