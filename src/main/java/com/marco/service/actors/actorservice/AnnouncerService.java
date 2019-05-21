package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Announcer;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface AnnouncerService extends ServiceGI<Announcer, Integer> {
    ArrayList<Announcer> getAllAnnouncers();
}
