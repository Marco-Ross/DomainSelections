package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;

public class LoginDetailFactory {
    public static LoginDetail buildLoginDetail(String username, String password, Customer customer, Profile profile){
        return new LoginDetail.Builder().username(username)
                .password(password)
                .customer(customer)
                .profile(profile)
                .build();
    }
}
