package com.marco.factory.bookings;

import com.marco.domain.bookings.OnlineBooking;
import org.junit.Test;

import static org.junit.Assert.*;

public class OnlineBookingFactoryTest {

    @Test
    public void getOnlineBooking() {
        int carriageBooked = 1;
        OnlineBooking onlineBooking = OnlineBookingFactory.getOnlineBooking(carriageBooked);
        assertSame(onlineBooking.getCarriageBooked(), 1);
    }
}