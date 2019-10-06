package com.marco.service.credentials.credentialservice;

import com.marco.domain.credentials.Profile;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface ProfileService extends ServiceGI<Profile, Integer, Optional<Profile>> {
    ArrayList<Profile> getAllProfiles();
}
