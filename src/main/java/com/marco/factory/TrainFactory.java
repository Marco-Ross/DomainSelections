package com.marco.factory;

import com.marco.domain.Train;
import com.marco.util.OverBook;

public class TrainFactory {
    public static Train getTrain(int trainNumber, int capacity){
        return new Train.Builder().trainNumber(trainNumber)
                .capacity(capacity + OverBook.overbookTrains())
                .build();
    }
}
