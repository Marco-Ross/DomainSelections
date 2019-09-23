package com.marco.factory.transit;

import com.marco.domain.transit.Train;
import com.marco.util.OverBook;
import com.marco.util.RandomID;

public class TrainFactory {
    public static Train buildTrain(String trainNumber, int capacity){
        return new Train.Builder().trainID(RandomID.generateRandomID())
                .capacity(capacity + OverBook.overbookTrains())
                .trainNumber(trainNumber)
                .build();
    }
}
