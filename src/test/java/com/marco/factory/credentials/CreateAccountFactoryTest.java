package com.marco.factory.credentials;

import com.marco.domain.credentials.CreateAccount;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CreateAccountFactoryTest {

    @Test
    public void getCreateAccount() {
        String accountType = "Premium";
        Date creationDate = new Date();
        CreateAccount createAccount = CreateAccountFactory.getCreateAccount(accountType, creationDate);
        assertNotNull(createAccount.getAccountType());
    }
}