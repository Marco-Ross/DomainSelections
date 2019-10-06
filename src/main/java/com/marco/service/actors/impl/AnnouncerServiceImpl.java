package com.marco.service.actors.impl;

import com.marco.domain.actors.Announcer;
import com.marco.repository.actors.actorrepo.AnnouncerRepository;
import com.marco.service.actors.actorservice.AnnouncerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("AnnouncerServiceImpl")//Stereotype for service layer
public class AnnouncerServiceImpl implements AnnouncerService {
    @Autowired
    //@Qualifier("AnnouncerSecondRepoImpl") //could use AnnouncerFirstImpl to get different implementation of repository
    private AnnouncerRepository repository;

    @Override
    public ArrayList<Announcer> getAllAnnouncers() {
        return (ArrayList<Announcer>) this.repository.findAll();
    }

    @Override
    public Announcer create(Announcer announcer) {
        return this.repository.save(announcer);
    }

    @Override
    public Announcer update(Announcer announcer) {
        return this.repository.save(announcer);
    }

    @Override
    public void delete(Integer announcer) {
        this.repository.deleteById(announcer);
    }

    @Override
    public Optional<Announcer> read(Integer announcer) {
        return this.repository.findById(announcer);
    }
}
