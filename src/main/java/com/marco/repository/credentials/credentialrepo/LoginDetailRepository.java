package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.LoginDetail;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface LoginDetailRepository extends RepositoryGI<LoginDetail, String> {
    Set<LoginDetail> getAllLoginDetails();
}
