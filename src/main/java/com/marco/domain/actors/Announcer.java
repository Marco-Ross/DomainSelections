package com.marco.domain.actors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Announcer implements Employee{
    @Id
    private int employeeNumber;

    private String name;
    private String surname;

    private Announcer(){}

    private Announcer(Builder builder){
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

        public Builder copy(Announcer announcer){
            this.name = announcer.name;
            this.surname = announcer.surname;
            this.employeeNumber = announcer.employeeNumber;

            return this;
        }

        public Announcer build(){return new Announcer(this);}
    }

    @Override
    public double salary() {
        return 0;
    }
}
