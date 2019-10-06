package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Announcer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnnouncerRepository extends CrudRepository<Announcer, Integer> {
    //ArrayList<Announcer> getAllAnnouncers(); //was used in repo Impl
}
