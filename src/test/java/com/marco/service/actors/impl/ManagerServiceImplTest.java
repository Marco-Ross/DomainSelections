package com.marco.service.actors.impl;

import com.marco.domain.actors.Manager;
import com.marco.factory.actors.ManagerFactory;
import com.marco.service.actors.actorservice.ManagerService;
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

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerServiceImplTest {
    @Autowired
    @Qualifier("ManagerServiceImpl")
    private ManagerService service;
    private Manager manager;

    private Manager getRepo(){
        for(Manager managerA : service.getAllManagers()){
            if(managerA.getEmployeeNumber() == manager.getEmployeeNumber()){
                return managerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        manager = ManagerFactory.buildManager(5532, "marco", "ross");
    }

    @Test
    public void d_getAllManagers() {
        ArrayList<Manager> arrayList = service.getAllManagers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Manager managerTest = this.service.create(manager);
        Assert.assertEquals(manager.getEmployeeNumber(), managerTest.getEmployeeNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "rusoo";
        Manager updated = new Manager.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Manager updated");
    }

    @Test
    public void e_delete() {
        service.delete(manager.getEmployeeNumber());
        ArrayList<Manager> managerList = service.getAllManagers();
        Assert.assertEquals(0, managerList.size());
    }

    @Test
    public void b_read() {
        Optional<Manager> managerRead = service.read(5532);
        Assert.assertTrue(managerRead.isPresent());
        Assert.assertEquals(manager.getEmployeeNumber(), managerRead.get().getEmployeeNumber());
    }
}