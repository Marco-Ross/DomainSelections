package com.marco.service.actors.impl;

import com.marco.domain.actors.Security;
import com.marco.repository.actors.actorrepo.SecurityRepository;
import com.marco.repository.actors.impl.SecurityRepositoryImpl;
import com.marco.service.actors.actorservice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("SecurityServiceImpl")
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    @Qualifier("SecurityRepoImpl")
    private SecurityRepository repository;

    @Override
    public Set<Security> getAllSecurity() {
        return this.repository.getAllSecurity();
    }

    @Override
    public Security create(Security security) {
        return this.repository.create(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.update(security);
    }

    @Override
    public void delete(Integer security) {
        this.repository.delete(security);
    }

    @Override
    public Security read(Integer security) {
        return this.repository.read(security);
    }
}
