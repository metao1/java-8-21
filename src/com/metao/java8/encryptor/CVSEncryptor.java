package com.metao.java8.encryptor;

import java.util.Base64;

public class CVSEncryptor {

    public static byte[] encrypt(String $$) {
        return Base64.getEncoder().encode($$.getBytes());
    }

    public static byte[] decrypt(String $$) {
        return Base64.getDecoder().decode($$);
    }
}
