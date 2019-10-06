package com.marco.repository.timings.timingrepo;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
