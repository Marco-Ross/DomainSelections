package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train, Integer> {
}
