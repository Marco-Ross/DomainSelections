package com.marco.service.credentials.impl;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.factory.credentials.ProfileFactory;
import com.marco.service.credentials.credentialservice.LoginDetailService;
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
public class LoginDetailServiceImplTest {
    @Autowired
    @Qualifier("LoginDetailServiceImpl")
    private LoginDetailService service;
    private LoginDetail loginDetail;

    private LoginDetail getRepo(){
        for(LoginDetail loginDetailA : service.getAllLoginDetails()){
            if(loginDetailA.getUsername().equals(loginDetail.getUsername())){
                return loginDetailA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 20, "54587896321", 250);
        Profile profile = ProfileFactory.buildProfile(6,"foolie");
        loginDetail = LoginDetailFactory.buildLoginDetail("marolo", "passwordo1", customer, profile);
    }

    @Test
    public void d_getAllLoginDetails() {
        Set<LoginDetail> set = service.getAllLoginDetails();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        LoginDetail loginDetailTest = this.service.create(loginDetail);
        Assert.assertEquals(loginDetail, loginDetailTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String username = "mynewUsername";
        LoginDetail updated = new LoginDetail.Builder().copy(getRepo()).username(username).build();

        this.service.update(updated);

        Assert.assertSame(username, updated.getUsername());
        System.out.println("LoginDetails updated");
    }

    @Test
    public void e_delete() {
        service.delete(loginDetail.getUsername());
        Set<LoginDetail> loginDetails = service.getAllLoginDetails();
        Assert.assertEquals(0, loginDetails.size());
    }

    @Test
    public void b_read() {
        LoginDetail loginDetailRead = service.read("marolo");
        Assert.assertEquals(loginDetail.getUsername(), loginDetailRead.getUsername());
    }
}