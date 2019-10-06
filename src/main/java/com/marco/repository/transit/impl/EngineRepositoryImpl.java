//package com.marco.repository.transit.impl;
//
//import com.marco.domain.transit.Engine;
//import com.marco.repository.transit.transitrepo.EngineRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//
//@Repository("EngineRepoImpl")
//public class EngineRepositoryImpl implements EngineRepository {
//    private ArrayList<Engine> engines;
//
//    private EngineRepositoryImpl(){
//        this.engines = new ArrayList<>();
//    }
//
//    @Override
//    public ArrayList<Engine> getAllEngines() {
//        return this.engines;
//    }
//
//    @Override
//    public Engine create(Engine engine) {
//        this.engines.add(engine);
//        for(Engine engineA : engines){
//            if(engine == engineA){
//                return engineA;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Engine update(Engine engine) {
//        for(int i = 0; i<engines.size();i++){
//            if(engine.getEngineNumber() == engines.get(i).getEngineNumber()){
//                this.engines.set(i, engine);
//                return engine;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Integer engineNumber) {
//        for(Engine engineA : engines){
//            if(engineNumber == engineA.getEngineNumber()){
//                this.engines.remove(engineA);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public Engine read(Integer engineNumber) {
//        for(Engine engineA : engines){
//            if(engineNumber == engineA.getEngineNumber()){
//                return engineA;
//            }
//        }
//        return null;
//    }
//}
