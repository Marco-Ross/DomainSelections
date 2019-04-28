package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Manager;
import com.marco.factory.actors.ManagerFactory;
import com.marco.repository.repositoryinterfaces.actorrepo.ManagerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerRepositoryImplTest {
    private ManagerRepository repository;
    private Manager manager;

    @Before
    public void setUp() throws Exception {
        this.repository = ManagerRepositoryImpl.getRepository();
        manager = ManagerFactory.getManager("marco", "ross", 5532);
        this.repository.create(manager); //create and add customer to data structure
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Manager> managerList = repository.getAllManagers();
        managerList.clear();
    }

    @Test
    public void getAllManagers() {
        ArrayList<Manager> arrayList = repository.getAllManagers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Manager managerCreate = ManagerFactory.getManager("peter", "guy", 3045);
        Manager mangerTestCreate = this.repository.create(managerCreate); //create and add customer to data structure

        Assert.assertEquals(managerCreate, mangerTestCreate);
    }

    @Test
    public void update() {
        Manager managerTest = ManagerFactory.getManager("marco", "hardy", 5532);
        this.repository.update(managerTest); //update customer details

        ArrayList<Manager> managerList = repository.getAllManagers(); //get all customers
        Assert.assertTrue(managerList.contains(managerTest));
        System.out.println("Manager updated");
    }

    @Test
    public void delete() {
        repository.delete(manager);
        ArrayList<Manager> managerList = repository.getAllManagers();
        Assert.assertEquals(0, managerList.size());
    }

    @Test
    public void read() {
        Manager managerRead = repository.read(5532);
        Assert.assertEquals(manager, managerRead);
    }
}