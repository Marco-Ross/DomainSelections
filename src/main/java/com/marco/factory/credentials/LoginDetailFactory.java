package com.marco.factory.credentials;

import com.marco.domain.credentials.LoginDetail;

public class LoginDetailFactory {
    public static LoginDetail getLoginDetail(String username, String password){
        return new LoginDetail.Builder().username(username)
                .password(password)
                .build();
    }
}
