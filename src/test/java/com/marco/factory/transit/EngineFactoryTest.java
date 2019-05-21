package com.marco.factory.transit;

import com.marco.domain.transit.Engine;
import org.junit.Test;

import static org.junit.Assert.*;

public class EngineFactoryTest {

    @Test
    public void getEngine() {
        int engineNumber = 225;
        String modelName = "Rooman";

        Engine engine = EngineFactory.buildEngine(engineNumber, modelName);
        assertNotNull(engine.getModelName());
    }
}