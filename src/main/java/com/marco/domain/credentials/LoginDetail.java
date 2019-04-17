package com.marco.domain.credentials;

public class LoginDetail {
    private String username;
    private String password;

    private LoginDetail() {
    }

    private LoginDetail(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private String username;
        private String password;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public LoginDetail build(){return new LoginDetail(this);}
    }
}
