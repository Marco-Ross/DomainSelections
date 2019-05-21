package com.marco.domain.actors;

public class Customer implements Employee {
    private String name;
    private String surname;
    private int age;
    private String idNumber;
    private double balance;

    private Customer(){}

    private Customer(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.idNumber = builder.idNumber;
        this.balance = builder.balance;
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

    public double getBalance() {
        return balance;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private String idNumber;
        private double balance;

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

        public Builder balance(double balance){
            this.balance = balance;
            return this;
        }

        public Builder copy(Customer customer){
            this.name = customer.name;
            this.surname = customer.surname;
            this.age = customer.age;
            this.idNumber = customer.idNumber;
            this.balance = customer.balance;

            return this;
        }

        public Customer build(){return new Customer(this);}
    }

    @Override
    public double salary() {
        return 0;
    }
}
