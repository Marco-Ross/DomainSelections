package com.marco.factory.credentials;

import com.marco.domain.credentials.Profile;

public class ProfileFactory {
    public static Profile getProfile(String displayName){
        return new Profile.Builder().displayName(displayName)
                .build();
    }
}
