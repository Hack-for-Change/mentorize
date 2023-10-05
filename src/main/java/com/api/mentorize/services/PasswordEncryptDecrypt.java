package com.api.mentorize.services;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
@Service
public class PasswordEncryptDecrypt {
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA256";

    public static String encrypt(String password, String plaintext) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        IvParameterSpec ivParams = cipher.getParameters().getParameterSpec(IvParameterSpec.class);
        byte[] iv = ivParams.getIV();
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes("UTF-8"));

        byte[] saltAndCiphertext = new byte[salt.length + iv.length + ciphertext.length];
        System.arraycopy(salt, 0, saltAndCiphertext, 0, salt.length);
        System.arraycopy(iv, 0, saltAndCiphertext, salt.length, iv.length);
        System.arraycopy(ciphertext, 0, saltAndCiphertext, salt.length + iv.length, ciphertext.length);

        return Base64.getEncoder().encodeToString(saltAndCiphertext);
    }

    public static String decrypt(String password, String encrypted) throws Exception {
        byte[] saltAndCiphertext = Base64.getDecoder().decode(encrypted);
        byte[] salt = new byte[16];
        byte[] iv = new byte[16];
        byte[] ciphertext = new byte[saltAndCiphertext.length - 32];

        System.arraycopy(saltAndCiphertext, 0, salt, 0, 16);
        System.arraycopy(saltAndCiphertext, 16, iv, 0, 16);
        System.arraycopy(saltAndCiphertext, 32, ciphertext, 0, ciphertext.length);

        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
        byte[] plaintextBytes = cipher.doFinal(ciphertext);

        return new String(plaintextBytes, "UTF-8");
    }

}
