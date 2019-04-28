package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ScheduleFactoryTest {
    private Date departureTime;
    private Date arrivalTime;

    @Test
    public void getSchedule() {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(0, 0, 0,4,5,0);
        arrive.set(0,0,0,5,0,0);
        departureTime = depart.getTime();
        arrivalTime = arrive.getTime();
        Train train = TrainFactory.getTrain(1522, 30);

        Schedule schedule = ScheduleFactory.getSchedule(departureTime, arrivalTime, train);
        assertNotNull(schedule.getTrainNumber());
    }
}