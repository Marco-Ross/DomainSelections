package com.marco.domain.credentials;

public class Profile {
    private  int profileId;
    private String displayName;

    private Profile() {
    }

    private Profile(Builder builder){
        this.profileId = builder.profileId;
        this.displayName = builder.displayName;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static class Builder{
        private  int profileId;
        private String displayName;

        public Builder profileId(int profileId){
            this.profileId = profileId;
            return this;
        }

        public Builder displayName(String displayName){
            this.displayName = displayName;
            return this;
        }

        public Builder copy(Profile profile){
            this.profileId = profile.profileId;
            this.displayName = profile.displayName;

            return this;
        }

        public Profile build(){return new Profile(this);}
    }
}
