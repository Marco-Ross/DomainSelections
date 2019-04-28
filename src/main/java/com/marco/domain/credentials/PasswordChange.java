package com.marco.domain.credentials;

import com.marco.domain.actors.Customer;
import sun.rmi.runtime.Log;

import java.nio.charset.Charset;
import java.util.Random;

public class PasswordChange {
    private LoginDetail loginDetail;

    private PasswordChange() {
    }

    private PasswordChange(Builder builder){
        this.loginDetail = builder.loginDetail;
    }

    public String getCustomerPassword() {
        return loginDetail.getPassword();
    }

    public String GeneratePassword(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));

    }

    public static class Builder{
        private LoginDetail loginDetail;

        public Builder loginDetail(LoginDetail loginDetail){
            this.loginDetail = loginDetail;
            return this;
        }

        public PasswordChange build(){return new PasswordChange(this);}
    }
}
