package com.marco.repository.impl.credentialimpl;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.repository.repositoryinterfaces.credentialrepo.LoginDetailRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class LoginDetailRepositoryImplTest {
    private LoginDetailRepository repository;
    private LoginDetail loginDetail;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = CustomerFactory.getCustomer("marco", "ross", 20, "54587896321", 250);
        this.repository = LoginDetailRepositoryImpl.getRepository();
        loginDetail = LoginDetailFactory.getLoginDetail("marolo", "passwordo1", customer);
        this.repository.create(loginDetail);
    }

    @After
    public void tearDown() throws Exception {
        Set<LoginDetail> set = repository.getAllLoginDetails();
        set.clear();
    }

    @Test
    public void getAllLoginDetails() {
        Set<LoginDetail> set = repository.getAllLoginDetails();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        LoginDetail loginDetail = LoginDetailFactory.getLoginDetail("marolo", "passwordo1", customer);
        LoginDetail loginDetailTest = this.repository.create(loginDetail);

        Assert.assertEquals(loginDetail, loginDetailTest);
    }

    @Test
    public void update() {
        LoginDetail loginDetail = LoginDetailFactory.getLoginDetail("marolo", "passwordo1", customer);
        this.repository.update(loginDetail);

        Set<LoginDetail> loginDetails = repository.getAllLoginDetails();
        Assert.assertTrue(loginDetails.contains(loginDetail));
        System.out.println("LoginDetails updated");
    }

    @Test
    public void delete() {
        repository.delete(loginDetail);
        Set<LoginDetail> loginDetails = repository.getAllLoginDetails();
        Assert.assertEquals(0, loginDetails.size());
    }

    @Test
    public void read() {
        LoginDetail loginDetailRead = repository.read("marolo");
        Assert.assertEquals(loginDetail, loginDetailRead);
    }
}