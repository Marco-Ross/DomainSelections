package com.marco.repository.repositoryinterfaces.credentialrepo;

import com.marco.domain.credentials.LoginDetail;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface LoginDetailRepository extends RepositoryGI<LoginDetail, String> {
    Set<LoginDetail> getAllLoginDetails();
}
