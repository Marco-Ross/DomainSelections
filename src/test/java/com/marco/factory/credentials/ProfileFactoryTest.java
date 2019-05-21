package com.marco.factory.credentials;

import com.marco.domain.credentials.Profile;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileFactoryTest {

    @Test
    public void getProfile() {
        String displayName = "PietTheGreat";
        Profile profile = ProfileFactory.buildProfile(12, displayName);
        assertNotNull(profile.getDisplayName());
    }
}