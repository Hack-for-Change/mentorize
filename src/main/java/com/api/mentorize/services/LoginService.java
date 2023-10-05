package com.api.mentorize.services;

import com.api.mentorize.repositories.logins.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.api.mentorize.models.Login;
import com.api.mentorize.dtos.LoginDTO;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class LoginService {
    private static final String AES = "AES";
    private static final String SECRET_KEY = "mentorize";
    @Autowired
    LoginRepository loginRepository;

    public Login save(LoginDTO loginDTO) {
        var login = new Login();
        BeanUtils.copyProperties(loginDTO, login);
        var pass = encrypt(loginDTO.password());
        login.setPassword(pass);
        return loginRepository.save(login);
    }

    public Login update(LoginDTO loginDTO, UUID id) {
        return loginRepository.update(loginDTO, id);
    }

    public Set<Login> findAll(PageRequest pageRequest) {
        return loginRepository.findAll(pageRequest).toSet();
    }

    public Optional<Login> findById(UUID id) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findById(id));
        return login;
    }
    public Optional<Login> findByEmail(String email) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findByEmail(email));
        return login;
    }
    public Optional<Login> findByPhone(String phone) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findByPhone(phone));
        return login;
    }

    public void removeById(UUID id) {
        loginRepository.removeById(id);
    }
    public static String encrypt(String password) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedPassword) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
