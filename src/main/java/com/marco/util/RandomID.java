package com.marco.util;

import java.util.UUID;

public class RandomID {
    public static String generateRandomID(){
        return UUID.randomUUID().toString();
    }
}
