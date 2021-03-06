package com.marco.factory.credentials;

import com.marco.domain.credentials.Profile;

public class ProfileFactory {
    public static Profile buildProfile(int profileId, String displayName){
        return new Profile.Builder().profileId(profileId)
                .displayName(displayName)
                .build();
    }
}
