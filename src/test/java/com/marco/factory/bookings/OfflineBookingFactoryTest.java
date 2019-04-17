package com.marco.factory.bookings;

import com.marco.domain.bookings.OfflineBooking;
import org.junit.Test;

import static org.junit.Assert.*;

public class OfflineBookingFactoryTest {

    @Test
    public void getOfflineBooking() {
        int offlineQuantityBooked = 60;
        OfflineBooking offlineBooking = OfflineBookingFactory.getOfflineBooking(offlineQuantityBooked);
        assertSame(offlineBooking.getOfflineQuantityBooked(), 60);
    }
}