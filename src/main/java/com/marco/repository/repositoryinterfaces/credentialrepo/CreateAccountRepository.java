package com.marco.repository.repositoryinterfaces.credentialrepo;

import com.marco.domain.credentials.CreateAccount;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Date;
import java.util.Set;

public interface CreateAccountRepository extends RepositoryGI<CreateAccount, String> {
    Set<CreateAccount> getAllAccountsCreated();
}
