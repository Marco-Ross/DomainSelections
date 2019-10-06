package com.marco.repository.timings.timingrepo;

import com.marco.domain.timings.compositeclass.TrainSchedule;
import org.springframework.data.repository.CrudRepository;

public interface TrainScheduleRepository extends CrudRepository<TrainSchedule, Integer> {
}
