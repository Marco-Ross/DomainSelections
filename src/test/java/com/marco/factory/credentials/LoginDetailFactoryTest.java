package com.marco.factory.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;
import com.marco.factory.actors.CustomerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginDetailFactoryTest {

    @Test
    public void getLoginDetail() {
        String pass = "password01";

        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 20, "12345678910", 200);
        Profile profile = ProfileFactory.buildProfile(2,"pookie");
        LoginDetail loginDetail = LoginDetailFactory.buildLoginDetail("laome", pass, customer, profile);

        assertSame(pass, loginDetail.getPassword());
    }
}