package br.com.touros.punterbot.api.core.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordSecret {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static String Enconde(String raw) {
        return ENCODER.encode(raw);
    }

    public static Boolean Matches(String raw, String encoded) {
        return ENCODER.matches(raw, encoded);
    }
}
