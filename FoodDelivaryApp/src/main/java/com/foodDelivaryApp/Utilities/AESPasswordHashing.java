package com.foodDelivaryApp.Utilities;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESPasswordHashing {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_SIZE = 256;

    public static String hashPassword(String password, String salt) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_SIZE);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes());

            // Encode the encrypted password to Base64
            return Base64.getEncoder().encodeToString(encryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage(), e);
        }
    }

    public static boolean verifyPassword(String hashedPassword, String password, String salt) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_SIZE);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(hashedPassword));

            return new String(decryptedPassword).equals(password);
        } catch (Exception e) {
            throw new RuntimeException("Error verifying password: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
    }
}
