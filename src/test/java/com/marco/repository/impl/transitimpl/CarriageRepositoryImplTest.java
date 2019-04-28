package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Carriage;
import com.marco.factory.transit.CarriageFactory;
import com.marco.repository.repositoryinterfaces.transitrepo.CarriageRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CarriageRepositoryImplTest {
    private CarriageRepository repository;
    private Carriage carriage;

    @Before
    public void setUp() throws Exception {
        this.repository = CarriageRepositoryImpl.getRepository();
        carriage = CarriageFactory.getCarriage(12, 50);
        this.repository.create(carriage);
    }

    @After
    public void tearDown() throws Exception {
        Set<Carriage> set = repository.getAllCarriages();
        set.clear();
    }

    @Test
    public void getAllCarriages() {
        Set<Carriage> set = repository.getAllCarriages();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        Carriage carriage = CarriageFactory.getCarriage(4, 30);
        Carriage carriageTest = this.repository.create(carriage);

        Assert.assertEquals(carriage, carriageTest);
    }

    @Test
    public void update() {
        Carriage carriage = CarriageFactory.getCarriage(12, 35);
        this.repository.update(carriage);

        Set<Carriage> carriages = repository.getAllCarriages();
        Assert.assertTrue(carriages.contains(carriage));
        System.out.println("Carriages updated");
    }

    @Test
    public void delete() {
        repository.delete(carriage);
        Set<Carriage> carriages = repository.getAllCarriages();
        Assert.assertEquals(0, carriages.size());
    }

    @Test
    public void read() {
        Carriage carriageRead = repository.read(12);
        Assert.assertEquals(carriage, carriageRead);
    }
}