package com.marco.domain.transit;

import javax.persistence.*;

@Entity
public class Train {
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int trainID;
    @Column(name = "train_capacity")
    private int capacity;
    private int trainNumber;

    private Train(){}

    private Train(Builder builder){
        this.trainID = builder.trainID;
        this.capacity = builder.capacity;
        this.trainNumber = builder.trainNumber;
    }

    public int getTrainID(){return trainID;}

    public int getCapacity(){return capacity;}

    public int getTrainNumber(){
        return trainNumber;
    }

    public static class Builder{
        private int trainID;
        private int capacity;
        private int trainNumber;

        public Builder trainID(int trainID){
            this.trainID = trainID;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder trainNumber(int trainNumber){
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

