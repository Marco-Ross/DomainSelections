package com.marco.factory.bookings;

import com.marco.domain.bookings.OnlineBooking;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class OnlineBookingFactoryTest {

    @Test
    public void getOnlineBooking() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        Date bookedDate = calendar.getTime();

        int carriageBooked = 1;
        OnlineBooking onlineBooking = OnlineBookingFactory.getOnlineBooking(12, bookedDate, carriageBooked);
        assertSame(onlineBooking.getCarriageBooked(), 1);
    }
}