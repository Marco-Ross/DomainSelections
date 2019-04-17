package com.marco.factory.credentials;

import com.marco.domain.credentials.PasswordChange;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordChangeFactoryTest {

    @Test
    public void getPasswordChange() {
        String previousPassword = "forgottenPAssWord";
        String generateNewPassword = "pj1poj23ns9f";
        PasswordChange password = PasswordChangeFactory.getPasswordChange(generateNewPassword);
        assertNotEquals(password.getGenerateNewPassword(), previousPassword);
    }
}