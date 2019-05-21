package com.marco.factory.transit;

import com.marco.domain.transit.Engine;

public class EngineFactory {
    public static Engine buildEngine(int engineNumber, String modelName){
        return new Engine.Builder().engineNumber(engineNumber)
                .modelName(modelName)
                .build();
    }
}
