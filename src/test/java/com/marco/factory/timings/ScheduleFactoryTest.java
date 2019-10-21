package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import org.junit.Assert;
import org.junit.Test;

import java.text.Format;
import java.text.SimpleDateFormat;
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

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String departureDateString = "10/20/2019";
        String departureString = formatter.format(departureTime);
        String arrivalString = formatter.format(arrivalTime);

        Schedule schedule = ScheduleFactory.buildSchedule(departureDateString, departureString, arrivalString);
        Assert.assertEquals(arrivalString, schedule.getArrival());
    }
}