//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Station;
//import com.marco.factory.transit.StationFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class StationRepositoryImplTest {
//    @Autowired
//    private StationRepository repository;
//    private Station station;
//
//    private Station getRepo(){
//        for(Station stationA : repository.findAll()){
//            if(stationA.getStationNumber() == station.getStationNumber()){
//                return stationA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        station = StationFactory.buildStation("Stikland", 12);
//    }
//
//    @Test
//    public void d_getAllStations() {
//        Set<Station> arrayList = (Set<Station>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Station stationTest = this.repository.save(station);
//
//        Assert.assertEquals(station, stationTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String stationName = "Maitland";
//        Station updated = new Station.Builder().copy(getRepo()).stationName(stationName).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(stationName, updated.getStationName());
//        System.out.println("Station updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(station.getStationNumber());
//        Set<Station> stations = (Set<Station> ) repository.findAll();
//        Assert.assertEquals(0, stations.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Station> stationRead = repository.findById(12);
//        Assert.assertTrue(stationRead.isPresent());
//        Assert.assertEquals(station.getStationNumber(), stationRead.get().getStationNumber());
//    }
//}