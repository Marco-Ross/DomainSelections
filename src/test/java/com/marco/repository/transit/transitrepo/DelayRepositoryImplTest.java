package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Station;
import com.marco.factory.transit.DelayFactory;
import com.marco.factory.transit.StationFactory;
import com.marco.repository.transit.transitrepo.DelayRepository;
import com.marco.repository.transit.impl.DelayRepositoryImpl;
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
public class DelayRepositoryImplTest {
    @Autowired
    @Qualifier("DelayRepoImpl")
    private DelayRepository repository;
    private Delay delay;

    private Delay getRepo(){
        for(Delay delayA : repository.getAllDelays()){
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
        Set<Delay> arrayList = repository.getAllDelays();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Delay delayTest = this.repository.create(delay);

        Assert.assertEquals(delay, delayTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String description = "Man stabbed";
        Delay updated = new Delay.Builder().copy(getRepo()).description(description).build();

        this.repository.update(updated);

        Assert.assertEquals(description, updated.getDescription());
        System.out.println("Delay updated");
    }

    @Test
    public void e_delete() {
        repository.delete(delay.getDelayId());
        Set<Delay> stations = repository.getAllDelays();
        Assert.assertEquals(0, stations.size());
    }

    @Test
    public void b_read() {
        Delay delayList = repository.read(10);
        Assert.assertEquals(delay.getDelayId(), delayList.getDelayId());
    }
}