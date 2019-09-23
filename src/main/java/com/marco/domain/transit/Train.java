package com.marco.domain.transit;

public class Train {
    private String trainID;
    private int capacity;
    private String trainNumber;

    private Train(){}

    private Train(Builder builder){
        this.trainID = builder.trainID;
        this.capacity = builder.capacity;
        this.trainNumber = builder.trainNumber;
    }

    public String getTrainID(){return trainID;}

    public int getCapacity(){return capacity;}

    public String getTrainNumber(){
        return trainNumber;
    }

    public static class Builder{
        private String trainID;
        private int capacity;
        private String trainNumber;

        public Builder trainID(String trainID){
            this.trainID = trainID;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder trainNumber(String trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder copy(Train train){
            this.trainID = train.trainID;
            this.capacity = train.capacity;
            this.trainNumber = train.trainNumber;

            return this;
        }

        public Train build(){return new Train(this);}
    }
}

