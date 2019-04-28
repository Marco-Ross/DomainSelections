package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.PasswordChange;
import com.marco.factory.actors.CustomerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordChangeFactoryTest {

    @Test
    public void getPasswordChange() {
        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "12345678910", 200);
        LoginDetail loginDetail = LoginDetailFactory.getLoginDetail("laome", "password01", customer);

        PasswordChange password = PasswordChangeFactory.getPasswordChange(loginDetail);

        assertNotEquals(password.GeneratePassword(), loginDetail.getPassword());
    }
}