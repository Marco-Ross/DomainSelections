package com.marco.repository.impl.credentialimpl;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.CreateAccount;
import com.marco.domain.credentials.LoginDetail;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.CreateAccountFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.repository.repositoryinterfaces.credentialrepo.CreateAccountRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class CreateAccountRepositoryImplTest {
    private CreateAccountRepository repository;
    private CreateAccount createAccount;
    private LoginDetail loginDetail;
    private Date creationDate;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        creationDate = calendar.getTime();

        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "54587896321", 250);
        loginDetail = LoginDetailFactory.getLoginDetail("marcuz", "pass01", customer);

        this.repository = CreateAccountRepositoryImpl.getRepository();
        createAccount = CreateAccountFactory.getCreateAccount(loginDetail, "free", creationDate);
        this.repository.create(createAccount);
    }

    @After
    public void tearDown() throws Exception {
        Set<CreateAccount> set = repository.getAllAccountsCreated();
        set.clear();
    }

    @Test
    public void getAllAccountsCreated() {
        Set<CreateAccount> set = repository.getAllAccountsCreated();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        CreateAccount createAccount = CreateAccountFactory.getCreateAccount(loginDetail, "free", creationDate);
        CreateAccount createAccountTest = this.repository.create(createAccount);

        Assert.assertEquals(createAccount, createAccountTest);
    }

    @Test
    public void update() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 6);
        creationDate = calendar.getTime();

        CreateAccount createAccount = CreateAccountFactory.getCreateAccount(loginDetail, "premium", creationDate);
        this.repository.update(createAccount);

        Set<CreateAccount> createAccounts = repository.getAllAccountsCreated();
        Assert.assertTrue(createAccounts.contains(createAccount));
        System.out.println("CreateAccounts updated");
    }

    @Test
    public void delete() {
        repository.delete(createAccount);
        Set<CreateAccount> bookingStatuses = repository.getAllAccountsCreated();
        Assert.assertEquals(0, bookingStatuses.size());
    }

    @Test
    public void read() {
        CreateAccount createAccountRead = repository.read("54587896321");
        Assert.assertEquals(createAccount, createAccountRead);
    }
}