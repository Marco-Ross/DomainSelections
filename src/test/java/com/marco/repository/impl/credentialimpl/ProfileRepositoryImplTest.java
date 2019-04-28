package com.marco.repository.impl.credentialimpl;

import com.marco.domain.credentials.Profile;
import com.marco.factory.credentials.ProfileFactory;
import com.marco.repository.repositoryinterfaces.credentialrepo.ProfileRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProfileRepositoryImplTest {
    private ProfileRepository repository;
    private Profile profile;

    @Before
    public void setUp() throws Exception {
        this.repository = ProfileRepositoryImpl.getRepository();
        profile = ProfileFactory.getProfile(2,"pookie");
        this.repository.create(profile);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Profile> arrayList = repository.getAllProfiles();
        arrayList.clear();
    }

    @Test
    public void getAllProfiles() {
        ArrayList<Profile> arrayList = repository.getAllProfiles();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Profile profile = ProfileFactory.getProfile(1,"tommy");
        Profile profileTest = this.repository.create(profile);

        Assert.assertEquals(profile, profileTest);
    }

    @Test
    public void update() {
        Profile profile = ProfileFactory.getProfile(2,"pookienew");
        this.repository.update(profile);

        ArrayList<Profile> profiles = repository.getAllProfiles();
        Assert.assertTrue(profiles.contains(profile));
        System.out.println("Profile updated");
    }

    @Test
    public void delete() {
        repository.delete(profile);
        ArrayList<Profile> profiles = repository.getAllProfiles();
        Assert.assertEquals(0, profiles.size());
    }

    @Test
    public void read() {
        Profile profileList = repository.read("pookie");
        Assert.assertEquals(profileList, profile);
    }
}