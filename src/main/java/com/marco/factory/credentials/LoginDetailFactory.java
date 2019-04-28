package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;

public class LoginDetailFactory {
    public static LoginDetail getLoginDetail(String username, String password, Customer customer){
        return new LoginDetail.Builder().username(username)
                .password(password)
                .customer(customer)
                .build();
    }
}
