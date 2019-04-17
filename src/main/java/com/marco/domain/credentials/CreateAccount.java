package com.marco.domain.credentials;

import java.util.Date;

public class CreateAccount {
    private String accountType;
    private Date creationDate;

    private CreateAccount() {
    }

    private CreateAccount(Builder builder){
        this.accountType = builder.accountType;
        this.creationDate = builder.creationDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public static class Builder{
        private String accountType;
        private Date creationDate;

        public Builder accountType(String accountType){
            this.accountType = accountType;
            return this;
        }

        public Builder creationDate(Date creationDate){
            this.creationDate = creationDate;
            return this;
        }

        public CreateAccount build(){return new CreateAccount(this);}
    }
}
