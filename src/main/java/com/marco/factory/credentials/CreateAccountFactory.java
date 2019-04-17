package com.marco.factory.credentials;

import com.marco.domain.credentials.CreateAccount;

import java.util.Date;

public class CreateAccountFactory {
    public static CreateAccount getCreateAccount(String accountType, Date creationDate){
        return new CreateAccount.Builder().accountType(accountType)
                .creationDate(creationDate)
                .build();
    }
}
