package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Security;
import com.marco.factory.actors.SecurityFactory;
import com.marco.repository.repositoryinterfaces.actorrepo.SecurityRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class SecurityRepositoryImplTest {
    private SecurityRepository repository;
    private Security security;

    @Before
    public void setUp() throws Exception {
        this.repository = SecurityRepositoryImpl.getRepository();
        security = SecurityFactory.getSecurity("marco", "ross", 3654);
        this.repository.create(security);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Security> arrayList = repository.getAllSecurity();
        arrayList.clear();
    }

    @Test
    public void getAllSecurity() {
        ArrayList<Security> arrayList = repository.getAllSecurity();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Security security = SecurityFactory.getSecurity("peter", "guy", 3045);
        Security securityTest = this.repository.create(security);

        Assert.assertEquals(security, securityTest);
    }

    @Test
    public void update() {
        Security security = SecurityFactory.getSecurity("marco", "hardy", 3654);
        this.repository.update(security);

        ArrayList<Security> securities = repository.getAllSecurity();
        Assert.assertTrue(securities.contains(security));
        System.out.println("Security updated");
    }

    @Test
    public void delete() {
        repository.delete(security);
        ArrayList<Security> securities = repository.getAllSecurity();
        Assert.assertEquals(0, securities.size());
    }

    @Test
    public void read() {
        Security securityList = repository.read(3654);
        Assert.assertEquals(securityList, security);
    }
}

///////////REFUND & PASSCHANGE