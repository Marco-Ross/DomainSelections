package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.Report;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ReportRepository extends CrudRepository<Report, Integer> {
}
