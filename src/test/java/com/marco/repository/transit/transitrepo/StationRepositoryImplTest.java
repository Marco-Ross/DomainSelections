package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Station;
import com.marco.factory.transit.StationFactory;
import com.marco.repository.transit.transitrepo.StationRepository;
import com.marco.repository.transit.impl.StationRepositoryImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StationRepositoryImplTest {
    @Autowired
    @Qualifier("StationRepoImpl")
    private StationRepository repository;
    private Station station;

    private Station getRepo(){
        for(Station stationA : repository.getAllStations()){
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
        Set<Station> arrayList = repository.getAllStations();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Station stationTest = this.repository.create(station);

        Assert.assertEquals(station, stationTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String stationName = "Maitland";
        Station updated = new Station.Builder().copy(getRepo()).stationName(stationName).build();

        this.repository.update(updated);

        Assert.assertEquals(stationName, updated.getStationName());
        System.out.println("Station updated");
    }

    @Test
    public void e_delete() {
        repository.delete(station.getStationNumber());
        Set<Station> stations = repository.getAllStations();
        Assert.assertEquals(0, stations.size());
    }

    @Test
    public void b_read() {
        Station stationList = repository.read(12);
        Assert.assertEquals(station.getStationNumber(), stationList.getStationNumber());
    }
}