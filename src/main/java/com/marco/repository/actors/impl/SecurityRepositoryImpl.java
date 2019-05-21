package com.marco.repository.actors.impl;

import com.marco.domain.actors.Security;
import com.marco.repository.actors.actorrepo.SecurityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Repository("SecurityRepoImpl")
public class SecurityRepositoryImpl implements SecurityRepository {
    private Set<Security> securities;

    private SecurityRepositoryImpl(){
        this.securities = new HashSet<>();
    }

    @Override
    public Set<Security> getAllSecurity() {
        return this.securities;
    }

    @Override
    public Security create(Security security) {
        this.securities.add(security);
        for(Security securityA : securities){
            if(security == securityA){
                return securityA;
            }
        }
        return null;
    }

    @Override
    public Security update(Security security) {
        for(Security securityA : securities){
            if(security.getEmployeeNumber() == securityA.getEmployeeNumber()){
                this.securities.remove(securityA);
                this.securities.add(security);
                return security;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer empNumb) {
        for(Security securityA : securities){
            if(empNumb == securityA.getEmployeeNumber()){
                this.securities.remove(securityA);
            }
        }
    }

    @Override
    public Security read(Integer empNumb) {
        for(Security securityA : securities){
            if(empNumb == securityA.getEmployeeNumber()){
                return securityA;
            }
        }
        return null;
    }
}
