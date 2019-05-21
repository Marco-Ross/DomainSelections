package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ScheduleFactoryTest {
    @Test
    public void getSchedule() {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(0, 0, 0,4,5,0);
        arrive.set(0,0,0,5,0,0);
        Date departureTime = depart.getTime();
        Date arrivalTime = arrive.getTime();
        Train train = TrainFactory.buildTrain(1522, 30, "Peter");

        Schedule schedule = ScheduleFactory.buildSchedule(departureTime, arrivalTime, train);
        Assert.assertEquals(arrivalTime, schedule.getArrival());
    }
}