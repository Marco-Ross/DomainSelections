package com.marco.domain.credentials;

import com.marco.domain.actors.Customer;

public class LoginDetail {
    private String username;
    private String password;
    private Customer customer;

    private LoginDetail() {
    }

    private LoginDetail(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.customer = builder.customer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static class Builder{
        private String username;
        private String password;
        private Customer customer;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public LoginDetail build(){return new LoginDetail(this);}
    }
}
