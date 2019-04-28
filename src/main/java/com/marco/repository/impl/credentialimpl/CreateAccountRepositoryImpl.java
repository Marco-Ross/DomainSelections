package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.CreateAccount;
import com.marco.repository.repositoryinterfaces.credentialrepo.CreateAccountRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateAccountRepositoryImpl implements CreateAccountRepository {
    private static CreateAccountRepositoryImpl repository = null;
    private Set<CreateAccount> createAccounts;

    private CreateAccountRepositoryImpl(){
        this.createAccounts = new HashSet<>();
    }

    public static CreateAccountRepositoryImpl getRepository(){
        if(repository == null) repository = new CreateAccountRepositoryImpl();
        return repository;
    }

    @Override
    public Set<CreateAccount> getAllAccountsCreated() {
        return this.createAccounts;
    }

    @Override
    public CreateAccount create(CreateAccount createAccount) {
        this.createAccounts.add(createAccount);
        return createAccount;
    }

    @Override //account composed of loginDetail
    public CreateAccount update(CreateAccount createAccount) {
        for(CreateAccount createA : createAccounts){
            if(createAccount.getCustomerId().equals(createA.getCustomerId())){ //&& used for loginDetail
                this.createAccounts.remove(createA);
                this.createAccounts.add(createAccount);
            }
        }
        return createAccount;
    }

    @Override
    public void delete(CreateAccount createAccount) {
        this.createAccounts.remove(createAccount);
    }

    @Override
    public CreateAccount read(String username) {
        CreateAccount createAccount = null;
        for(CreateAccount createA : createAccounts){
            if(username.equals(createA.getCustomerId())){ //&& used for loginDetail
                createAccount = createA;
            }
        }
        return createAccount;
    }
}
