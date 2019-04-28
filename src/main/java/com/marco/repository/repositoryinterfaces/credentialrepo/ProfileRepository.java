package com.marco.repository.repositoryinterfaces.credentialrepo;

import com.marco.domain.credentials.Profile;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface ProfileRepository extends RepositoryGI<Profile, String> {
    ArrayList<Profile> getAllProfiles();
}
