package com.marco.factory.actors;

import com.marco.domain.actors.DoorMan;

public class DoorManFactory {
    public static DoorMan buildDoorMan(int employeeNumber, String name, String surname){
        return new DoorMan.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
