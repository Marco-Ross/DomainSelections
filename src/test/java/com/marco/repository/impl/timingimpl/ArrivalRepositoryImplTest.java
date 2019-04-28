package com.marco.repository.impl.timingimpl;

import com.marco.domain.timings.Arrival;
import com.marco.domain.timings.Departure;
import com.marco.factory.timings.ArrivalFactory;
import com.marco.factory.timings.DepartureFactory;
import com.marco.repository.repositoryinterfaces.timingrepo.ArrivalRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class ArrivalRepositoryImplTest {
    private ArrivalRepository repository;
    private Arrival arrival;

    @Before
    public void setUp() throws Exception {
          this.repository = ArrivalRepositoryImpl.getRepository();
        arrival = ArrivalFactory.getArrival(2, "Parow");
        this.repository.create(arrival);
    }

    @After
    public void tearDown() throws Exception {
        Set<Arrival> set = repository.getAllArrivals();
        set.clear();
    }

    @Test
    public void getAllArrivals() {
        Set<Arrival> set = repository.getAllArrivals();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        Arrival arrival = ArrivalFactory.getArrival(3,"Parow");
        Arrival arrivalTest = this.repository.create(arrival);

        Assert.assertEquals(arrival, arrivalTest);
    }

    @Test
    public void update() {
        Arrival arrival = ArrivalFactory.getArrival(2, "Tygerberg");
        this.repository.update(arrival);

        Set<Arrival> arrivals = repository.getAllArrivals();
        Assert.assertTrue(arrivals.contains(arrival));
        System.out.println("Arrival updated");
    }

    @Test
    public void delete() {
        repository.delete(arrival);
        Set<Arrival> arrivals = repository.getAllArrivals();
        Assert.assertEquals(0, arrivals.size());
    }

    @Test
    public void read() {
        Arrival arrivalTest = repository.read("Parow");
        Assert.assertEquals(arrival, arrivalTest);
    }
}