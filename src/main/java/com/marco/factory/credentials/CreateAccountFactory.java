package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.CreateAccount;
import com.marco.domain.credentials.LoginDetail;

import java.util.Date;

//Add account holder to attributes
public class CreateAccountFactory {
    public static CreateAccount getCreateAccount(LoginDetail loginDetails, String accountType, Date creationDate){
        return new CreateAccount.Builder().loginDetails(loginDetails)
                .accountType(accountType)
                .creationDate(creationDate)
                .build();
    }
}
