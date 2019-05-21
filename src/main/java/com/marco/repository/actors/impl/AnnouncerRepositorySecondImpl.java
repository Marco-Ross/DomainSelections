package com.marco.repository.actors.impl;

import com.marco.domain.actors.Announcer;
import com.marco.repository.actors.actorrepo.AnnouncerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
//Stereotype for persistence layer
//@Repository is a specialized part(more specific part) of @Component
@Repository("AnnouncerSecondRepoImpl") //DAO(Data Access Object) fulfills the roll/stereotype of a repository | //@Repository specifies that this class is inside the IoC container and can be injected(wired) to other classes from within springs application ctx
public class AnnouncerRepositorySecondImpl implements AnnouncerRepository {

    //private static AnnouncerRepositoryImpl repository = null;
    private ArrayList<Announcer> announcers;

    //Spring uses reflection api to access the private constructor and initialize the data set within springs application context
    private AnnouncerRepositorySecondImpl(){
        this.announcers = new ArrayList<>();
    }

    //Singleton that was called to retrieve the instance of AnnouncerRepoImpl. Spring is now used to inject the dependency directly into the object where needed
    //public static AnnouncerRepositoryImpl getRepository(){
    //   if(repository == null) repository = new AnnouncerRepositoryImpl();
    //    return repository;
    //}

    @Override
    public ArrayList<Announcer> getAllAnnouncers() {
        return this.announcers;
    }

    @Override
    public Announcer create(Announcer announcer) {
        this.announcers.add(announcer);
        for(Announcer announcerA : announcers){
            if(announcer == announcerA){
                return announcerA;
            }
        }
        return null;
    }

    @Override
    public Announcer update(Announcer announcer) {
        for(int i = 0; i<announcers.size();i++){
            if(announcer.getEmployeeNumber() == announcers.get(i).getEmployeeNumber()){
                Announcer updatedAnnouncer = new Announcer.Builder().copy(announcer).surname(announcer.getSurname() + "SecondImpl").build();
                this.announcers.set(i, updatedAnnouncer);
                return announcer;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer empNumb) {
        for(Announcer announcerA : announcers){
            if(announcerA.getEmployeeNumber() == empNumb){
                this.announcers.remove(announcerA);
                break;
            }
        }
    }

    @Override
    public Announcer read(Integer empNumb) {
        for(Announcer announcerA : announcers){
            if(empNumb == announcerA.getEmployeeNumber()){
                return announcerA;
            }
        }
        return null;
    }
}