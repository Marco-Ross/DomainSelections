package com.marco.service.credentials.impl;

import com.marco.domain.credentials.LoginDetail;
import com.marco.repository.credentials.credentialrepo.LoginDetailRepository;
import com.marco.repository.credentials.impl.LoginDetailRepositoryImpl;
import com.marco.service.credentials.credentialservice.LoginDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LoginDetailServiceImpl")
public class LoginDetailServiceImpl implements LoginDetailService {
    @Autowired
    @Qualifier("LoginDetailRepoImpl")
    private LoginDetailRepository repository;

    @Override
    public Set<LoginDetail> getAllLoginDetails() {
        return this.repository.getAllLoginDetails();
    }

    @Override
    public LoginDetail create(LoginDetail loginDetail) {
        return this.repository.create(loginDetail);
    }

    @Override
    public LoginDetail update(LoginDetail loginDetail) {
        return this.repository.update(loginDetail);
    }

    @Override
    public void delete(String loginDetail) {
        this.repository.delete(loginDetail);
    }

    @Override
    public LoginDetail read(String loginDetail) {
        return this.repository.read(loginDetail);
    }
}
