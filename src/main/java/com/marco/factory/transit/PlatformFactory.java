package com.marco.factory.transit;

import com.marco.domain.transit.Platform;

import java.util.Date;

public class PlatformFactory {
    public static Platform getPlatform(int platformNumber, Date platformTrainArrivalTime){
        return new Platform.Builder().platformNumber(platformNumber)
                .platformTrainArrivalTime(platformTrainArrivalTime)
                .build();
    }
}
