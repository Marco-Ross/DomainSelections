package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BookingStatusRepository extends CrudRepository<BookingStatus, Integer> {
}
