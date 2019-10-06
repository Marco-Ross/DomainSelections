package com.marco.domain.transit;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Engine {
    @Id
    private int engineNumber;
    private String modelName;

    private Engine(){}

    private Engine(Builder builder){
        this.engineNumber = builder.engineNumber;
        this.modelName = builder.modelName;
    }

    public int getEngineNumber() {
        return engineNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public static class Builder{
        private int engineNumber;
        private String modelName;

        public Builder engineNumber(int engineNumber){
            this.engineNumber = engineNumber;
            return this;
        }

        public Builder modelName(String modelName){
            this.modelName = modelName;
            return this;
        }

        public Builder copy(Engine engine){
            this.engineNumber = engine.engineNumber;
            this.modelName = engine.modelName;

            return this;
        }

        public Engine build(){
            return new Engine(this);
        }
    }
}
