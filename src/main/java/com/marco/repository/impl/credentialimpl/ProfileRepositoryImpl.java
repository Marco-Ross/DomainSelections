package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.Profile;
import com.marco.repository.repositoryinterfaces.credentialrepo.ProfileRepository;

import java.util.ArrayList;

public class ProfileRepositoryImpl implements ProfileRepository {
    private static ProfileRepositoryImpl repository = null;
    private ArrayList<Profile> profiles;

    private ProfileRepositoryImpl(){
        this.profiles = new ArrayList<>();
    }

    public static ProfileRepositoryImpl getRepository(){
        if(repository == null) repository = new ProfileRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Profile> getAllProfiles() {
        return this.profiles;
    }

    @Override
    public Profile create(Profile profile) {
        this.profiles.add(profile);
        return profile;
    }

    @Override
    public Profile update(Profile profile) {
        for(int i = 0; i<profiles.size();i++){
            if(profile.getProfileId() == profiles.get(i).getProfileId()){
                this.profiles.set(i, profile);
            }
        }
        return profile;
    }

    @Override
    public void delete(Profile profile) {
        this.profiles.remove(profile);
    }

    @Override
    public Profile read(String displayName) {
        Profile profile = null;
        for(Profile managerA : profiles){
            if(displayName.equals(managerA.getDisplayName())){
                profile = managerA;
            }
        }
        return profile;
    }
}
