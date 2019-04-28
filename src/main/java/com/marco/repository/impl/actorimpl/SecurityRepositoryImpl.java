package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Security;
import com.marco.repository.repositoryinterfaces.actorrepo.SecurityRepository;

import java.util.ArrayList;

public class SecurityRepositoryImpl implements SecurityRepository {
    private static SecurityRepositoryImpl repository = null;
    private ArrayList<Security> securities;

    private SecurityRepositoryImpl(){
        this.securities = new ArrayList<>();
    }

    public static SecurityRepositoryImpl getRepository(){
        if(repository == null) repository = new SecurityRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Security> getAllSecurity() {
        return this.securities;
    }

    @Override
    public Security create(Security security) {
        this.securities.add(security);
        return security;
    }

    @Override
    public Security update(Security security) {
        for(int i = 0; i<securities.size();i++){
            if(security.getEmployeeNumber() == securities.get(i).getEmployeeNumber()){
                this.securities.set(i, security);
            }
        }
        return security;
    }

    @Override
    public void delete(Security security) {
        this.securities.remove(security);
    }

    @Override
    public Security read(Integer empNumb) {
        Security security = null;
        for(Security securityA : securities){
            if(empNumb == securityA.getEmployeeNumber()){
                security = securityA;
            }
        }
        return security;
    }
}
