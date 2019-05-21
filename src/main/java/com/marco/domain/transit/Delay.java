package com.marco.domain.transit;

public class Delay {
    private int delayId;
    private Station station;
    private String description;

    private Delay(){}

    private Delay(Builder builder){
        this.delayId = builder.delayId;
        this.station = builder.station;
        this.description = builder.description;
    }

    public int getDelayId() {
        return delayId;
    }

    public Station getStation() {
        return station;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private int delayId;
        private Station station;
        private String description;

        public Builder delayId(int delayId){
            this.delayId = delayId;
            return this;
        }

        public Builder station(Station station){
            this.station = station;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder copy(Delay delay){
            this.delayId = delay.delayId;
            this.station = delay.station;
            this.description = delay.description;

            return this;
        }

        public Delay build(){
            return new Delay(this);
        }
    }
}
