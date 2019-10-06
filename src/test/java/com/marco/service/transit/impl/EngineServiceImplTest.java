package com.marco.service.transit.impl;

import com.marco.domain.transit.Engine;
import com.marco.factory.transit.EngineFactory;
import com.marco.service.transit.transitservice.EngineService;
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

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EngineServiceImplTest {
    @Autowired
    @Qualifier("EngineServiceImpl")
    private EngineService service;
    private Engine engine;

    private Engine getRepo(){
        for(Engine engineA : service.getAllEngines()){
            if(engineA.getEngineNumber() == engine.getEngineNumber()){
                return engineA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        engine = EngineFactory.buildEngine(2553, "Royce");
    }

    @Test
    public void d_getAllEngines() {
        ArrayList<Engine> arrayList = service.getAllEngines();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Engine engineTest = this.service.create(engine);

        Assert.assertEquals(engine.getEngineNumber(), engineTest.getEngineNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String modelName = "Roycaye";
        Engine updated = new Engine.Builder().copy(getRepo()).modelName(modelName).build();

        this.service.update(updated);

        Assert.assertEquals(modelName, updated.getModelName());
        System.out.println("Engine updated");
    }

    @Test
    public void e_delete() {
        service.delete(engine.getEngineNumber());
        ArrayList<Engine> engines = service.getAllEngines();
        Assert.assertEquals(0, engines.size());
    }

    @Test
    public void b_read() {
        Optional<Engine> engineRead = service.read(2553);
        Assert.assertTrue(engineRead.isPresent());
        Assert.assertEquals(engine.getEngineNumber(), engineRead.get().getEngineNumber());
    }
}