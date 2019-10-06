package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;

public interface OfflineBookingRepository extends CrudRepository<OfflineBooking, Integer> {
}
