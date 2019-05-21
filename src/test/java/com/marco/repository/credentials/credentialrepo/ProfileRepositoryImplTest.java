package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.Profile;
import com.marco.factory.credentials.ProfileFactory;
import com.marco.repository.credentials.impl.ProfileRepositoryImpl;
import com.marco.repository.credentials.credentialrepo.ProfileRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfileRepositoryImplTest {
    @Autowired
    @Qualifier("ProfileRepoImpl")
    private ProfileRepository repository;
    private Profile profile;

    private Profile getRepo(){
        for(Profile profileA : repository.getAllProfiles()){
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
        ArrayList<Profile> arrayList = repository.getAllProfiles();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Profile profileTest = this.repository.create(profile);
        Assert.assertEquals(profile, profileTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String displayName = "zipmezap";
        Profile updated = new Profile.Builder().copy(getRepo()).displayName(displayName).build();

        this.repository.update(updated);

        Assert.assertSame(displayName, updated.getDisplayName());
        System.out.println("Profile updated");
    }

    @Test
    public void e_delete() {
        repository.delete(profile.getProfileId());
        ArrayList<Profile> profiles = repository.getAllProfiles();
        Assert.assertEquals(0, profiles.size());
    }

    @Test
    public void b_read() {
        Profile profileRead = repository.read(2);
        Assert.assertEquals(profile.getProfileId(), profileRead.getProfileId());
    }
}