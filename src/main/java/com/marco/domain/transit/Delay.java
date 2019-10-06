package com.marco.domain.transit;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Delay {
    @Id
    private int delayId;
    private String description;

    private Delay(){}

    private Delay(Builder builder){
        this.delayId = builder.delayId;
        this.description = builder.description;
    }

    public int getDelayId() {
        return delayId;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private int delayId;
        private String description;

        public Builder delayId(int delayId){
            this.delayId = delayId;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder copy(Delay delay){
            this.delayId = delay.delayId;
            this.description = delay.description;

            return this;
        }

        public Delay build(){
            return new Delay(this);
        }
    }
}
