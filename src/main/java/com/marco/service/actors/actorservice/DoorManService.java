package com.marco.service.actors.actorservice;

import com.marco.domain.actors.DoorMan;
import com.marco.service.ServiceGI;

import java.util.Optional;
import java.util.Set;

public interface DoorManService extends ServiceGI<DoorMan, Integer, Optional<DoorMan>> {
    Set<DoorMan> getAllDoorMen();
}
