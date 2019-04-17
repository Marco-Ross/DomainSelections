package com.marco.factory.transit;

import com.marco.domain.transit.Carriage;

public class CarriageFactory {
    public static Carriage getCarriage(int carriageNumber, int capacity){
        return new Carriage.Builder().carriageNumber(carriageNumber)
                .capacity(capacity)
                .build();
    }
}
