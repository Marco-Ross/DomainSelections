package com.marco.domain.actors;

public class Customer implements Employee {
    private String name;
    private String surname;
    private int age;
    private String idNumber;

    private Customer(){}

    private Customer(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.idNumber = builder.idNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private String idNumber;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder idNumber(String idNumber){
            this.idNumber = idNumber;
            return this;
        }

        public Customer build(){return new Customer(this);}
    }

    @Override
    public double salary() {
        return 0;
    }
}
