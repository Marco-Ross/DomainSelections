package com.marco.factory.transit;

import com.marco.domain.transit.Train;
import com.marco.util.OverBook;

public class TrainFactory {
    public static Train buildTrain(int trainNumber, int capacity, String trainName){
        return new Train.Builder().trainNumber(trainNumber)
                .capacity(capacity + OverBook.overbookTrains())
                .trainName(trainName)
                .build();
    }
}
