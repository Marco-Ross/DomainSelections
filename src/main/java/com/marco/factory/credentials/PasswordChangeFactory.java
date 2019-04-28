package com.marco.factory.credentials;

import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.PasswordChange;

public class PasswordChangeFactory {
    public static PasswordChange getPasswordChange(LoginDetail loginDetail){
        return new PasswordChange.Builder().loginDetail(loginDetail)
                .build();
    }
}
