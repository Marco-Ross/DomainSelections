package com.marco.factory.transit;

import com.marco.domain.transit.Train;
import com.marco.util.OverBook;

public class TrainFactory {
    public static Train getTrain(int trainNumber, int capacity){
        return new Train.Builder().trainNumber(trainNumber)
                .capacity(capacity + OverBook.overbookTrains())
                .build();
    }
}
