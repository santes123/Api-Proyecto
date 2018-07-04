package com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.API_KEY;
import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.FORM_ID;
import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.PRIVATE_KEY;

/**
 * Created by pumpun5 on 4/10/17.
 */

public class UtilityMethods{

    public UtilityMethods() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
    }

    private static String hmacSha1(String value, String key)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException {
        String type = "HmacSHA1";
        SecretKeySpec secret = new SecretKeySpec(key.getBytes(), type);
        Mac mac = Mac.getInstance(type);
        mac.init(secret);
        byte[] bytes = mac.doFinal(value.getBytes());
        return bytesToHex(bytes);
    }

    private final static char[] hexArray = "0123456789abcdef".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    //METODO GUARDAR DATOS DEL FORMULARIO
    public static void saveData(){
    }
    //MEOTODO CREAR URL ACCESO
    public static class HmacSha1Signature {
        private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";


        public static String calculateRFC2104HMAC(String data, String key)
                throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            return base64Encode2String(mac.doFinal(data.getBytes()));
        }


        private static String base64Encode2String(final byte[] input) {
            return Base64.encodeToString(input, Base64.NO_WRAP);
        }
    }


}