package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Station;
import com.marco.factory.transit.StationFactory;
import com.marco.repository.repositoryinterfaces.transitrepo.StationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StationRepositoryImplTest {
    private StationRepository repository;
    private Station station;

    @Before
    public void setUp() throws Exception {
        this.repository = StationRepositoryImpl.getRepository();
        station = StationFactory.getStation("Stikland", 12);
        this.repository.create(station);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Station> arrayList = repository.getAllStations();
        arrayList.clear();
    }

    @Test
    public void getAllStations() {
        ArrayList<Station> arrayList = repository.getAllStations();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Station station = StationFactory.getStation("Bellville", 11);
        Station stationTest = this.repository.create(station);

        Assert.assertEquals(station, stationTest);
    }

    @Test
    public void update() {
        Station station = StationFactory.getStation("Maitland", 12);
        this.repository.update(station);

        ArrayList<Station> stations = repository.getAllStations();
        Assert.assertTrue(stations.contains(station));
        System.out.println("Station updated");
    }

    @Test
    public void delete() {
        repository.delete(station);
        ArrayList<Station> stations = repository.getAllStations();
        Assert.assertEquals(0, stations.size());
    }

    @Test
    public void read() {
        Station stationList = repository.read(12);
        Assert.assertEquals(stationList, station);
    }
}