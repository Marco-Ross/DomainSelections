package com.marco.domain.credentials;

public class PasswordChange {
    private String generateNewPassword;

    private PasswordChange() {
    }

    private PasswordChange(Builder builder){
        this.generateNewPassword = builder.generateNewPassword;
    }

    public String getGenerateNewPassword() {
        return generateNewPassword;
    }

    public static class Builder{
        private String generateNewPassword;

        public Builder generateNewPassword(String generateNewPassword){
            this.generateNewPassword = generateNewPassword;
            return this;
        }

        public PasswordChange build(){return new PasswordChange(this);}
    }
}
