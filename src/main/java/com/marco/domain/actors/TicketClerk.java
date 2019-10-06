package com.marco.domain.actors;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class TicketClerk implements Employee{
    @Id
    private int employeeNumber;
    private String name;
    private String surname;

    private TicketClerk(){}

    private TicketClerk(Builder builder){
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

        public Builder copy(TicketClerk ticketClerk){
            this.name = ticketClerk.name;
            this.surname = ticketClerk.surname;
            this.employeeNumber = ticketClerk.employeeNumber;

            return this;
        }

        public TicketClerk build(){return new TicketClerk(this);}
    }

    @Override
    public double salary() {
        return 0;
    }
}
