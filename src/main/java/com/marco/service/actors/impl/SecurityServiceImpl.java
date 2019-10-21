package com.marco.service.actors.impl;

import com.google.common.collect.Sets;
import com.marco.domain.actors.Security;
import com.marco.repository.actors.actorrepo.SecurityRepository;
import com.marco.service.actors.actorservice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service("SecurityServiceImpl")
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private SecurityRepository repository;

    @Override
    public Set<Security> getAllSecurity() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Security create(Security security) {
        return this.repository.save(security);
    }

    @Override
    public Security update(Security security) {
        return this.repository.save(security);
    }

    @Override
    public void delete(Integer security) {
        this.repository.deleteById(security);
    }

    @Override
    public Optional<Security> read(Integer security) {
        return this.repository.findById(security);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
