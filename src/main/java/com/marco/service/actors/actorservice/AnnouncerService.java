package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Announcer;
import com.marco.service.ServiceGI;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.Optional;

public interface AnnouncerService extends ServiceGI<Announcer, Integer, Optional<Announcer>> {
    ArrayList<Announcer> getAllAnnouncers();
}
