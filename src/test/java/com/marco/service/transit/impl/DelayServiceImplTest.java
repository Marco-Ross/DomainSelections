package com.marco.service.transit.impl;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Station;
import com.marco.factory.transit.DelayFactory;
import com.marco.factory.transit.StationFactory;
import com.marco.service.transit.transitservice.DelayService;
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
public class DelayServiceImplTest {
    @Autowired
    @Qualifier("DelayServiceImpl")
    private DelayService service;
    private Delay delay;

    private Delay getRepo(){
        for(Delay delayA : service.getAllDelays()){
            if(delayA.getDelayId() == delay.getDelayId()){
                return delayA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Station station = StationFactory.buildStation("Stikland", 12);
        delay = DelayFactory.buildDelay(10, station, "Man hit by train");
    }

    @Test
    public void d_getAllStations() {
        Set<Delay> arrayList = service.getAllDelays();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Delay delayTest = this.service.create(delay);

        Assert.assertEquals(delay, delayTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String description = "Man stabbed";
        Delay updated = new Delay.Builder().copy(getRepo()).description(description).build();

        this.service.update(updated);

        Assert.assertEquals(description, updated.getDescription());
        System.out.println("Delay updated");
    }

    @Test
    public void e_delete() {
        service.delete(delay.getDelayId());
        Set<Delay> stations = service.getAllDelays();
        Assert.assertEquals(0, stations.size());
    }

    @Test
    public void b_read() {
        Delay delayList = service.read(10);
        Assert.assertEquals(delay.getDelayId(), delayList.getDelayId());
    }
}