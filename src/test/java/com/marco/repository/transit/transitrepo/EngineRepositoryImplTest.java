package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Engine;
import com.marco.factory.transit.EngineFactory;
import com.marco.repository.transit.transitrepo.EngineRepository;
import com.marco.repository.transit.impl.EngineRepositoryImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EngineRepositoryImplTest {
    @Autowired
    @Qualifier("EngineRepoImpl")
    private EngineRepository repository;
    private Engine engine;

    private Engine getRepo(){
        for(Engine engineA : repository.getAllEngines()){
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
        ArrayList<Engine> arrayList = repository.getAllEngines();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Engine engineTest = this.repository.create(engine);

        Assert.assertEquals(engine, engineTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String modelName = "Roycaye";
        Engine updated = new Engine.Builder().copy(getRepo()).modelName(modelName).build();

        this.repository.update(updated);

        Assert.assertEquals(modelName, updated.getModelName());
        System.out.println("Engine updated");
    }

    @Test
    public void e_delete() {
        repository.delete(engine.getEngineNumber());
        ArrayList<Engine> engines = repository.getAllEngines();
        Assert.assertEquals(0, engines.size());
    }

    @Test
    public void b_read() {
        Engine engineList = repository.read(2553);
        Assert.assertEquals(engine.getEngineNumber(), engineList.getEngineNumber());
    }
}