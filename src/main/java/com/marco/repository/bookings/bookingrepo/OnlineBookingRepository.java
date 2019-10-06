package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OnlineBookingRepository extends CrudRepository<OnlineBooking, Integer> {
}
