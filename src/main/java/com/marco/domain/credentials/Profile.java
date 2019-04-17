package com.marco.domain.credentials;

public class Profile {
    private String displayName;

    private Profile() {
    }

    private Profile(Builder builder){
        this.displayName = builder.displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static class Builder{
        private String displayName;

        public Builder displayName(String displayName){
            this.displayName = displayName;
            return this;
        }

        public Profile build(){return new Profile(this);}
    }
}
