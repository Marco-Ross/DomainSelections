package com.marco.domain.transit;

public class Carriage {
    private int carriageNumber;
    private int capacity;

    private Carriage() {
    }

    private Carriage(Builder builder){
        this.carriageNumber = builder.carriageNumber;
        this.capacity = builder.capacity;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class Builder{
        private int carriageNumber;
        private int capacity;

        public Builder carriageNumber(int carriageNumber){
            this.carriageNumber = carriageNumber;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Carriage build(){return new Carriage(this);}
    }
}