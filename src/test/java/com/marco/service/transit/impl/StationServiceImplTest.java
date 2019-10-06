package com.marco.service.transit.impl;

import com.marco.domain.transit.Station;
import com.marco.factory.transit.StationFactory;
import com.marco.service.transit.transitservice.StationService;
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
public class StationServiceImplTest {
    @Autowired
    @Qualifier("StationServiceImpl")
    private StationService service;
    private Station station;

    private Station getRepo(){
        for(Station stationA : service.getAllStations()){
            if(stationA.getStationNumber() == station.getStationNumber()){
                return stationA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        station = StationFactory.buildStation("Stikland", 12);
    }

    @Test
    public void d_getAllStations() {
        Set<Station> arrayList = service.getAllStations();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Station stationTest = this.service.create(station);

        Assert.assertEquals(station.getStationNumber(), stationTest.getStationNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String stationName = "Maitland";
        Station updated = new Station.Builder().copy(getRepo()).stationName(stationName).build();

        this.service.update(updated);

        Assert.assertEquals(stationName, updated.getStationName());
        System.out.println("Station updated");
    }

    @Test
    public void e_delete() {
        service.delete(station.getStationNumber());
        Set<Station> stations = service.getAllStations();
        Assert.assertEquals(0, stations.size());
    }

    @Test
    public void b_read() {
        Optional<Station> stationRead = service.read(12);
        Assert.assertTrue(stationRead.isPresent());
        Assert.assertEquals(station.getStationNumber(), stationRead.get().getStationNumber());
    }
}