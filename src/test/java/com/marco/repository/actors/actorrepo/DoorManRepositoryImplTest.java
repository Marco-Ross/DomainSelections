package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.DoorMan;
import com.marco.factory.actors.DoorManFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoorManRepositoryImplTest {
    @Autowired
    @Qualifier("DoorManRepoImpl")
    private DoorManRepository repository;
    private DoorMan doorMan;

    private DoorMan getRepo(){
        for(DoorMan doorManA : repository.getAllDoorMen()){
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
    public void d_getAllDrivers() {
        Set<DoorMan> doorMenSet = repository.getAllDoorMen();
        Assert.assertEquals(1, doorMenSet.size());
    }

    @Test
    public void a_create() {
        DoorMan doorManTest = this.repository.create(doorMan);
        Assert.assertEquals(doorMan, doorManTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "doopies";
        DoorMan updated = new DoorMan.Builder().copy(getRepo()).surname(surname).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("DoorMan updated");
    }

    @Test
    public void e_delete() {
        repository.delete(doorMan.getEmployeeNumber());
        Set<DoorMan> driverSet = repository.getAllDoorMen();
        Assert.assertEquals(0, driverSet.size());
    }

    @Test
    public void b_read() {
        DoorMan doorManRead = repository.read(3654);
        Assert.assertEquals(doorMan.getEmployeeNumber(), doorManRead.getEmployeeNumber());
    }
}