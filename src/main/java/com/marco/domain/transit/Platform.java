package com.marco.domain.transit;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Platform {
    @Id
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

        public Builder copy(Platform platform){
            this.platformNumber = platform.platformNumber;
            this.platformLength = platform.platformLength;

            return this;
        }

        public Platform build(){return new Platform(this);}
    }
}
