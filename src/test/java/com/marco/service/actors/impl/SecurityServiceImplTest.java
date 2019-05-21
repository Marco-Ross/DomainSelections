package com.marco.service.actors.impl;

import com.marco.domain.actors.Security;
import com.marco.factory.actors.SecurityFactory;
import com.marco.service.actors.actorservice.SecurityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecurityServiceImplTest {
    @Autowired
    @Qualifier("SecurityServiceImpl")
    private SecurityService service;
    private Security security;

    private Security getRepo(){
        for(Security securityA : service.getAllSecurity()){
            if(securityA.getEmployeeNumber() == security.getEmployeeNumber()){
                return security;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        security = SecurityFactory.buildSecurity("marco", "ross", 3654);
    }

    @Test
    public void d_getAllSecurity() {
        Set<Security> arrayList = service.getAllSecurity();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Security securityTest = this.service.create(security);
        Assert.assertEquals(security, securityTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "toolie";
        Security updated = new Security.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Security updated");
    }

    @Test
    public void e_delete() {
        service.delete(security.getEmployeeNumber());
        Set<Security> securities = service.getAllSecurity();
        Assert.assertEquals(0, securities.size());
    }

    @Test
    public void b_read() {
        Security securityRead = service.read(3654);
        Assert.assertEquals(security.getEmployeeNumber(), securityRead.getEmployeeNumber());
    }
}