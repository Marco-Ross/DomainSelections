package com.marco.factory.bookings;

import com.marco.domain.bookings.OfflineBooking;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class OfflineBookingFactoryTest {

    @Test
    public void getOfflineBooking() {
        int id = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        Date bookedDate = calendar.getTime();

        int offlineQuantityBooked = 60;

        OfflineBooking offlineBooking = OfflineBookingFactory.buildOfflineBooking(id ,bookedDate, offlineQuantityBooked);
        assertSame(offlineQuantityBooked, offlineBooking.getOfflineQuantityBooked());
    }
}