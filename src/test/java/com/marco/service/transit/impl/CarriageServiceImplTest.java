package com.marco.service.transit.impl;

import com.marco.domain.transit.Carriage;
import com.marco.factory.transit.CarriageFactory;
import com.marco.service.transit.transitservice.CarriageService;
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

import java.util.Optional;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarriageServiceImplTest {
    @Autowired
    @Qualifier("CarriageServiceImpl")
    private CarriageService service;
    private Carriage carriage;

    private Carriage getRepo(){
        for(Carriage carriageA : service.getAllCarriages()){
            if(carriageA.getCarriageNumber() == carriage.getCarriageNumber()){
                return carriageA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        carriage = CarriageFactory.buildCarriage(12, 50);
    }

    @Test
    public void d_getAllCarriages() {
        Set<Carriage> set = service.getAllCarriages();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        Carriage carriageTest = this.service.create(carriage);

        Assert.assertEquals(carriage.getCarriageNumber(), carriageTest.getCarriageNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        int capacity = 32;
        Carriage updated = new Carriage.Builder().copy(getRepo()).capacity(capacity).build();

        this.service.update(updated);

        Assert.assertEquals(capacity, updated.getCapacity());
        System.out.println("Carriages updated");
    }

    @Test
    public void e_delete() {
        service.delete(carriage.getCarriageNumber());
        Set<Carriage> carriages = service.getAllCarriages();
        Assert.assertEquals(0, carriages.size());
    }

    @Test
    public void b_read() {
        Optional<Carriage> carriageRead = service.read(12);
        Assert.assertTrue(carriageRead.isPresent());
        Assert.assertEquals(carriage.getCarriageNumber(), carriageRead.get().getCarriageNumber());
    }
}