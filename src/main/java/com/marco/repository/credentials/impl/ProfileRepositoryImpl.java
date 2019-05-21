package com.marco.repository.credentials.impl;

import com.marco.domain.credentials.Profile;
import com.marco.repository.credentials.credentialrepo.ProfileRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("ProfileRepoImpl")
public class ProfileRepositoryImpl implements ProfileRepository {
    private ArrayList<Profile> profiles;

    private ProfileRepositoryImpl(){
        this.profiles = new ArrayList<>();
    }

    @Override
    public ArrayList<Profile> getAllProfiles() {
        return this.profiles;
    }

    @Override
    public Profile create(Profile profile) {
        this.profiles.add(profile);
        for(Profile managerA : profiles){
            if(profile == managerA){
                return managerA;
            }
        }
        return null;
    }

    @Override
    public Profile update(Profile profile) {
        for(int i = 0; i<profiles.size();i++){
            if(profile.getProfileId() == profiles.get(i).getProfileId()){
                this.profiles.set(i, profile);
                return profile;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer profileId) {
        for(Profile managerA : profiles){
            if(profileId == managerA.getProfileId()){
                this.profiles.remove(managerA);
                break;
            }
        }
    }

    @Override
    public Profile read(Integer profileId) {
        for(Profile managerA : profiles){
            if(profileId == managerA.getProfileId()){
                return managerA;
            }
        }
        return null;
    }
}
