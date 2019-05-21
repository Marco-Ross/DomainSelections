package com.marco.service.credentials.impl;

import com.marco.domain.credentials.Profile;
import com.marco.repository.credentials.credentialrepo.ProfileRepository;
import com.marco.repository.credentials.impl.ProfileRepositoryImpl;
import com.marco.service.credentials.credentialservice.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ProfileServiceImpl")
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    @Qualifier("ProfileRepoImpl")
    private ProfileRepository repository;

    @Override
    public ArrayList<Profile> getAllProfiles() {
        return this.repository.getAllProfiles();
    }

    @Override
    public Profile create(Profile profile) {
        return this.repository.create(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.repository.update(profile);
    }

    @Override
    public void delete(Integer profile) {
        this.repository.delete(profile);
    }

    @Override
    public Profile read(Integer profile) {
        return this.repository.read(profile);
    }
}
