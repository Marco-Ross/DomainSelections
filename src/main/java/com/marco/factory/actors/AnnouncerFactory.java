package com.marco.factory.actors;

import com.marco.domain.actors.Announcer;

public class AnnouncerFactory {
    public static Announcer buildAnnouncer(String name, String surname, int employeeNumber){
        return new Announcer.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
