package com.marco.service.credentials.impl;

import com.marco.domain.credentials.Profile;
import com.marco.repository.credentials.credentialrepo.ProfileRepository;
import com.marco.service.credentials.credentialservice.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("ProfileServiceImpl")
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository repository;

    @Override
    public ArrayList<Profile> getAllProfiles() {
        return (ArrayList<Profile>) this.repository.findAll();
    }

    @Override
    public Profile create(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return this.repository.save(profile);
    }

    @Override
    public void delete(Integer profile) {
        this.repository.deleteById(profile);
    }

    @Override
    public Optional<Profile> read(Integer profile) {
        return this.repository.findById(profile);
    }
}
