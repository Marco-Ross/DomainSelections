package com.marco.factory.bookings;

import com.marco.domain.bookings.BookingStatus;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BookingStatusFactoryTest {

    @Test
    public void getBookingStatus() {
        Date date = new Date();
        BookingStatus bookingStatus = BookingStatusFactory.buildBookingStatus(366, date);
        assertNotNull(bookingStatus.getTimesBooked());
    }
}