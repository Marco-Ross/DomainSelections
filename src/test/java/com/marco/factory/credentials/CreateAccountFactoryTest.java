package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.CreateAccount;
import com.marco.domain.credentials.LoginDetail;
import com.marco.factory.actors.CustomerFactory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class CreateAccountFactoryTest {
    private LoginDetail loginDetail;
    private Date creationDate;

    @Test
    public void getCreateAccount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        creationDate = calendar.getTime();

        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "54587896321", 250);
        loginDetail = LoginDetailFactory.getLoginDetail("marcuz", "pass01", customer);

        CreateAccount createAccount = CreateAccountFactory.getCreateAccount(loginDetail, "free", creationDate);
        assertNotNull(createAccount.getAccountType());
    }
}