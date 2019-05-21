package com.marco.service.credentials.impl;

import com.marco.domain.credentials.Profile;
import com.marco.factory.credentials.ProfileFactory;
import com.marco.service.credentials.credentialservice.ProfileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfileServiceImplTest {
    @Autowired
    @Qualifier("ProfileServiceImpl")
    private ProfileService service;
    private Profile profile;

    private Profile getRepo(){
        for(Profile profileA : service.getAllProfiles()){
            if(profileA.getProfileId() == profile.getProfileId()){
                return profileA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        profile = ProfileFactory.buildProfile(2,"pookie");
    }

    @Test
    public void d_getAllProfiles() {
        ArrayList<Profile> arrayList = service.getAllProfiles();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Profile profileTest = this.service.create(profile);
        Assert.assertEquals(profile, profileTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String displayName = "zipmezap";
        Profile updated = new Profile.Builder().copy(getRepo()).displayName(displayName).build();

        this.service.update(updated);

        Assert.assertSame(displayName, updated.getDisplayName());
        System.out.println("Profile updated");
    }

    @Test
    public void e_delete() {
        service.delete(profile.getProfileId());
        ArrayList<Profile> profiles = service.getAllProfiles();
        Assert.assertEquals(0, profiles.size());
    }

    @Test
    public void b_read() {
        Profile profileRead = service.read(2);
        Assert.assertEquals(profile.getProfileId(), profileRead.getProfileId());
    }
}