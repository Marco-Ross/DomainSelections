package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.service.ServiceGI;

import java.util.Date;
import java.util.Set;

public interface OfflineBookingService extends ServiceGI<OfflineBooking, Date> {
    Set<OfflineBooking> getAllOfflineBookings();
}
