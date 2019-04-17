package com.marco.factory.credentials;

import com.marco.domain.credentials.PasswordChange;

public class PasswordChangeFactory {
    public static PasswordChange getPasswordChange(String generateNewPassword){
        return new PasswordChange.Builder().generateNewPassword(generateNewPassword)
                .build();
    }
}
