package com.marco.factory.transit;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Station;

public class DelayFactory {
    public static Delay buildDelay(int delayId, String description){
        return new Delay.Builder().delayId(delayId)
                .description(description)
                .build();
    }
}
