package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Manager;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface ManagerService extends ServiceGI<Manager, Integer, Optional<Manager>> {
    ArrayList<Manager> getAllManagers();
}
