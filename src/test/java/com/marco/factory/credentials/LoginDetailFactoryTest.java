package com.marco.factory.credentials;

import com.marco.domain.credentials.LoginDetail;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginDetailFactoryTest {

    @Test
    public void getLoginDetail() {
        String username = "notPiet";
        String password = "1252e(3$";
        LoginDetail loginDetail = LoginDetailFactory.getLoginDetail(username, password);
        assertSame(loginDetail.getPassword(), password);
    }
}