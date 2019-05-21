package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Manager;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface ManagerService extends ServiceGI<Manager, Integer> {
    ArrayList<Manager> getAllManagers();
}
