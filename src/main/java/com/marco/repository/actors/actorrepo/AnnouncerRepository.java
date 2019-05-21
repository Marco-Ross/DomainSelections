package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Announcer;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface AnnouncerRepository extends RepositoryGI<Announcer, Integer> {
    ArrayList<Announcer> getAllAnnouncers();
}
