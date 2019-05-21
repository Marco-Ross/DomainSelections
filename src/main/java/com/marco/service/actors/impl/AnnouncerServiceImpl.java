package com.marco.service.actors.impl;

import com.marco.domain.actors.Announcer;
import com.marco.repository.actors.actorrepo.AnnouncerRepository;
import com.marco.repository.actors.impl.AnnouncerRepositoryImpl;
import com.marco.repository.actors.impl.AnnouncerRepositorySecondImpl;
import com.marco.service.actors.actorservice.AnnouncerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service("AnnouncerServiceImpl")//Stereotype for service layer
public class AnnouncerServiceImpl implements AnnouncerService {
    @Autowired
    @Qualifier("AnnouncerSecondRepoImpl") //could use AnnouncerFirstImpl to get different implementation of repository
    private AnnouncerRepository repositorySecond;

    @Override
    public ArrayList<Announcer> getAllAnnouncers() {
        return this.repositorySecond.getAllAnnouncers();
    }

    @Override
    public Announcer create(Announcer announcer) {
        return this.repositorySecond.create(announcer);
    }

    @Override
    public Announcer update(Announcer announcer) {
        return this.repositorySecond.update(announcer);
    }

    @Override
    public void delete(Integer announcer) {
        this.repositorySecond.delete(announcer);
    }

    @Override
    public Announcer read(Integer announcer) {
        return this.repositorySecond.read(announcer);
    }
}
