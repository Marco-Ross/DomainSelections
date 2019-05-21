package com.marco.service.credentials.credentialservice;

import com.marco.domain.credentials.Profile;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface ProfileService extends ServiceGI<Profile, Integer> {
    ArrayList<Profile> getAllProfiles();
}
