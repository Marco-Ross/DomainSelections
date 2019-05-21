package com.marco.domain.transit;

public class Station {
    private String stationName;
    private int stationNumber;

    private Station() {
    }

    private Station(Builder builder){
        this.stationName = builder.stationName;
        this.stationNumber = builder.stationNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public static class Builder{
        private String stationName;
        private int stationNumber;

        public Builder stationName(String stationName){
            this.stationName = stationName;
            return this;
        }

        public Builder stationNumber(int stationNumber){
            this.stationNumber = stationNumber;
            return this;
        }

        public Builder copy(Station station){
            this.stationName = station.stationName;
            this.stationNumber = station.stationNumber;

            return this;
        }

        public Station build(){return new Station(this);}
    }
}
