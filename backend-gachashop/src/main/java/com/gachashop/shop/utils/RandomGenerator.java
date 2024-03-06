package com.gachashop.shop.utils;

import java.util.Random;

public class RandomGenerator {
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int RANDOM_STRING_LENGTH = 6;

    public static String generateRandomPassword() {
        StringBuilder sb = new StringBuilder(RANDOM_STRING_LENGTH);
        Random random = new Random();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
