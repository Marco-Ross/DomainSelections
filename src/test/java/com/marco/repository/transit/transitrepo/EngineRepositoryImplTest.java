//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Engine;
//import com.marco.factory.transit.EngineFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class EngineRepositoryImplTest {
//    @Autowired
//    private EngineRepository repository;
//    private Engine engine;
//
//    private Engine getRepo(){
//        for(Engine engineA : repository.findAll()){
//            if(engineA.getEngineNumber() == engine.getEngineNumber()){
//                return engineA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        engine = EngineFactory.buildEngine(2553, "Royce");
//    }
//
//    @Test
//    public void d_getAllEngines() {
//        ArrayList<Engine> arrayList = (ArrayList<Engine>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Engine engineTest = this.repository.save(engine);
//
//        Assert.assertEquals(engine, engineTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String modelName = "Roycaye";
//        Engine updated = new Engine.Builder().copy(getRepo()).modelName(modelName).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(modelName, updated.getModelName());
//        System.out.println("Engine updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(engine.getEngineNumber());
//        ArrayList<Engine> engines = (ArrayList<Engine>) repository.findAll();
//        Assert.assertEquals(0, engines.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Engine> engineRead = repository.findById(2553);
//        Assert.assertTrue(engineRead.isPresent());
//        Assert.assertEquals(engine.getEngineNumber(), engineRead.get().getEngineNumber());
//    }
//}