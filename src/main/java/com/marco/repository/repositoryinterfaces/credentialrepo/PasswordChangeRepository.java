package com.marco.repository.repositoryinterfaces.credentialrepo;

import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.PasswordChange;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface PasswordChangeRepository extends RepositoryGI<LoginDetail, String> {
    ArrayList<LoginDetail> getAllPasswordChanges();
}
