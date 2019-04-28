package com.marco.domain.transit;

import java.util.Date;

public class Platform {
    private int platformNumber;
    private int platformLength;

    private Platform() {
    }

    private Platform(Builder builder){
        this.platformNumber = builder.platformNumber;
        this.platformLength = builder.platformLength;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public int getPlatformLength() {
        return platformLength;
    }

    public static class Builder{
        private int platformNumber;
        private int platformLength;

        public Builder platformNumber(int platformNumber){
            this.platformNumber = platformNumber;
            return this;
        }

        public Builder platformLength(int platformLength){
            this.platformLength = platformLength;
            return this;
        }

        public Platform build(){return new Platform(this);}
    }
}
