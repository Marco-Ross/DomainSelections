package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.LoginDetail;
import com.marco.repository.repositoryinterfaces.credentialrepo.LoginDetailRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginDetailRepositoryImpl implements LoginDetailRepository {
    private static LoginDetailRepositoryImpl repository = null;
    private Set<LoginDetail> loginDetails;

    private LoginDetailRepositoryImpl(){
        this.loginDetails = new HashSet<>();
    }

    public static LoginDetailRepositoryImpl getRepository(){
        if(repository == null) repository = new LoginDetailRepositoryImpl();
        return repository;
    }

    @Override
    public Set<LoginDetail> getAllLoginDetails() {
        return this.loginDetails;
    }

    @Override
    public LoginDetail create(LoginDetail loginDetail) {
        this.loginDetails.add(loginDetail);
        return loginDetail;
    }

    @Override
    public LoginDetail update(LoginDetail loginDetail) {
        for(LoginDetail loginDetailA : loginDetails){
            if(loginDetail.getUsername().equals(loginDetailA.getUsername())){
                this.loginDetails.remove(loginDetailA);
                this.loginDetails.add(loginDetail);
            }
        }
        return loginDetail;
    }

    @Override
    public void delete(LoginDetail loginDetail) {
        this.loginDetails.remove(loginDetail);
    }

    @Override
    public LoginDetail read(String username) {
        LoginDetail loginDetail = null;
        for(LoginDetail loginDetailA : loginDetails){
            if(username.equals(loginDetailA.getUsername())){
                loginDetail = loginDetailA;
            }
        }
        return loginDetail;
    }
}
