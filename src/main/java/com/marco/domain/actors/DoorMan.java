package com.marco.domain.actors;

import com.marco.domain.credentials.LoginDetail;

import java.util.Date;

public class DoorMan {
    private String name;
    private String surname;
    private int employeeNumber;

    private DoorMan(){}

    private DoorMan(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.employeeNumber = builder.employeeNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int employeeNumber;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder employeeNumber(int employeeNumber){
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder copy(DoorMan doorMan){
            this.name = doorMan.name;
            this.surname = doorMan.surname;
            this.employeeNumber = doorMan.employeeNumber;

            return this;
        }

        public DoorMan build(){return new DoorMan(this);}
    }
}
