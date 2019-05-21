package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.Profile;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface ProfileRepository extends RepositoryGI<Profile, Integer> {
    ArrayList<Profile> getAllProfiles();
}
