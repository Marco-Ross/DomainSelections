package com.marco.domain.credentials;

import com.marco.domain.actors.Customer;
import sun.rmi.runtime.Log;

import java.util.Date;

public class CreateAccount {
    private LoginDetail loginDetails;
    private String accountType;
    private Date creationDate;

    private CreateAccount() {
    }

    private CreateAccount(Builder builder){
        this.loginDetails = builder.loginDetails;
        this.accountType = builder.accountType;
        this.creationDate = builder.creationDate;
    }

    public LoginDetail getLoginDetails() {
        return loginDetails;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCustomerId(){
        return getLoginDetails().getCustomer().getIdNumber();
    }

    public static class Builder{
        private LoginDetail loginDetails;
        private String accountType;
        private Date creationDate;

        public Builder loginDetails(LoginDetail loginDetails){
            this.loginDetails = loginDetails;
            return this;
        }

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
