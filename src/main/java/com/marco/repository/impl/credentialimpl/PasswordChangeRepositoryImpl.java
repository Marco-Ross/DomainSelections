package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.PasswordChange;
import com.marco.repository.repositoryinterfaces.credentialrepo.PasswordChangeRepository;

import java.util.ArrayList;

public class PasswordChangeRepositoryImpl implements PasswordChangeRepository {
    private static PasswordChangeRepositoryImpl repository = null;
    private ArrayList<LoginDetail> loginDetailsPassChange;

    private PasswordChangeRepositoryImpl(){
        this.loginDetailsPassChange = new ArrayList<>();
    }

    public static PasswordChangeRepositoryImpl getRepository(){
        if(repository == null) repository = new PasswordChangeRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<LoginDetail> getAllPasswordChanges() {
        return this.loginDetailsPassChange;
    }

    @Override
    public LoginDetail create(LoginDetail passwordChange) {
        this.loginDetailsPassChange.add(passwordChange);
        return passwordChange;
    }

    @Override
    public LoginDetail update(LoginDetail loginDetails) {
        for(int i = 0; i<loginDetailsPassChange.size();i++){
            if(loginDetails.getUsername().equals(loginDetailsPassChange.get(i).getUsername())){
                this.loginDetailsPassChange.set(i, loginDetails);
            }
        }
        return loginDetails;
    }

    @Override
    public void delete(LoginDetail passwordChange) {
        //this.passwordChanges.remove(passwordChange);
    }

    @Override
    public LoginDetail read(String username) {
        LoginDetail loginDetail = null;
        for(LoginDetail loginDetailA : loginDetailsPassChange){
            if(username.equals(loginDetailA.getUsername())){
                loginDetail = loginDetailA;
            }
        }
        return loginDetail;
    }
}
