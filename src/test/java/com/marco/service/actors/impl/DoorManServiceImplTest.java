package com.marco.service.actors.impl;

import com.marco.domain.actors.DoorMan;
import com.marco.factory.actors.DoorManFactory;
import com.marco.service.actors.actorservice.DoorManService;
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
public class DoorManServiceImplTest {
    @Autowired
    @Qualifier("DoorManServiceImpl")
    private DoorManService service;
    private DoorMan doorMan;

    private DoorMan getRepo(){
        for(DoorMan doorManA : service.getAllDoorMen()){
            if(doorManA.getEmployeeNumber() == doorMan.getEmployeeNumber()){
                return doorManA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        doorMan = DoorManFactory.buildDoorMan("marco", "ross", 3654);
    }

    @Test
    public void d_getAllTicketClerks() {
        Set<DoorMan> arrayList = service.getAllDoorMen();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        DoorMan doorManTest = this.service.create(doorMan);
        Assert.assertEquals(doorMan, doorManTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "doosie";
        DoorMan updated = new DoorMan.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("DoorMan updated");
    }

    @Test
    public void e_delete() {
        service.delete(doorMan.getEmployeeNumber());
        Set<DoorMan> ticketClerks = service.getAllDoorMen();
        Assert.assertEquals(0, ticketClerks.size());
    }

    @Test
    public void b_read() {
        DoorMan doorManRead = service.read(3654);
        Assert.assertEquals(doorMan.getEmployeeNumber(), doorManRead.getEmployeeNumber());
    }
}