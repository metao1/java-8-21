package com.metao.examples.encryptor;

import java.util.Base64;

public class CVSEncryptor {

    public static byte[] encrypt(byte[] $$) {
        return Base64.getEncoder().encode($$);
    }

    public static void encryptString(String input){
        System.out.printf("%s", input.getBytes().length);
    }

    public static byte[] decrypt(byte[] $$) {
        return Base64.getDecoder().decode($$);
    }
}
