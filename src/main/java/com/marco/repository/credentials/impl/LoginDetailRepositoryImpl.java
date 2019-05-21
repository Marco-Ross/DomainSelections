package com.marco.repository.credentials.impl;

import com.marco.domain.credentials.LoginDetail;
import com.marco.repository.credentials.credentialrepo.LoginDetailRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("LoginDetailRepoImpl")
public class LoginDetailRepositoryImpl implements LoginDetailRepository {
    private Set<LoginDetail> loginDetails;

    private LoginDetailRepositoryImpl(){
        this.loginDetails = new HashSet<>();
    }

    @Override
    public Set<LoginDetail> getAllLoginDetails() {
        return this.loginDetails;
    }

    @Override
    public LoginDetail create(LoginDetail loginDetail) {
        this.loginDetails.add(loginDetail);
        for(LoginDetail loginDetailA : loginDetails){
            if(loginDetail.equals(loginDetailA)){
                return loginDetailA;
            }
        }
        return null;
    }

    @Override
    public LoginDetail update(LoginDetail loginDetail) {
        for(LoginDetail loginDetailA : loginDetails){
            if(loginDetail.getUsername().equals(loginDetailA.getUsername())){
                this.loginDetails.remove(loginDetailA);
                this.loginDetails.add(loginDetail);
                return loginDetail;
            }
        }
        return null;
    }

    @Override
    public void delete(String username) { //Customer info is dependant on loginDetails, if loginDetails is deleted customerInfo must also be deleted! PROFILE ALSO SHOULD BE ADDED
        for(LoginDetail loginDetailA : loginDetails){
            if(username.equals(loginDetailA.getUsername())){
                this.loginDetails.remove(loginDetailA);
            }
        }
    }

    @Override
    public LoginDetail read(String username) {
        for(LoginDetail loginDetailA : loginDetails){
            if(username.equals(loginDetailA.getUsername())){
                return loginDetailA;
            }
        }
        return null;
    }
}
