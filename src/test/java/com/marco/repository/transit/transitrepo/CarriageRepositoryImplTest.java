package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Carriage;
import com.marco.factory.transit.CarriageFactory;
import com.marco.repository.transit.transitrepo.CarriageRepository;
import com.marco.repository.transit.impl.CarriageRepositoryImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarriageRepositoryImplTest {
    @Autowired
    @Qualifier("CarriageRepoImpl")
    private CarriageRepository repository;
    private Carriage carriage;

    private Carriage getRepo(){
        for(Carriage carriageA : repository.getAllCarriages()){
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
        Set<Carriage> set = repository.getAllCarriages();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        Carriage carriageTest = this.repository.create(carriage);

        Assert.assertEquals(carriage, carriageTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        int capacity = 32;
        Carriage updated = new Carriage.Builder().copy(getRepo()).capacity(capacity).build();

        this.repository.update(updated);

        Assert.assertEquals(capacity, updated.getCapacity());
        System.out.println("Carriages updated");
    }

    @Test
    public void e_delete() {
        repository.delete(carriage.getCarriageNumber());
        Set<Carriage> carriages = repository.getAllCarriages();
        Assert.assertEquals(0, carriages.size());
    }

    @Test
    public void b_read() {
        Carriage carriageRead = repository.read(12);
        Assert.assertEquals(carriage.getCarriageNumber(), carriageRead.getCarriageNumber());
    }
}