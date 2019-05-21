package com.marco.factory.actors;

import com.marco.domain.actors.DoorMan;
import com.marco.domain.credentials.LoginDetail;

import java.util.Date;

public class DoorManFactory {
    public static DoorMan buildDoorMan(String name, String surname, int employeeNumber){
        return new DoorMan.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
