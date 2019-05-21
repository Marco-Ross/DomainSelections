package com.marco.controller.credentials;

import com.marco.domain.credentials.Profile;
import com.marco.factory.credentials.ProfileFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfileControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/profile";

    @Test
    public void a_create() {
        Profile profile = ProfileFactory.buildProfile(2,"pookie");

        ResponseEntity<Profile> postResponse = restTemplate.postForEntity(baseURL + "/create", profile, Profile.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Profile profile = restTemplate.getForObject(baseURL + "/read/2", Profile.class);
        Profile updated = new Profile.Builder().copy(profile).displayName("zumba").build();
        restTemplate.put(baseURL + "/update", updated);

        Profile updatedProfile = restTemplate.getForObject(baseURL + "/read/2", Profile.class);

        assertNotNull(updatedProfile);
        assertEquals(updated.getProfileId(), updatedProfile.getProfileId());
    }

    @Test
    public void e_delete() {
        Profile profile = restTemplate.getForObject(baseURL + "/read/2", Profile.class);
        assertNotNull(profile);
        assertEquals(2, profile.getProfileId());

        restTemplate.delete(baseURL + "/delete/" + profile.getProfileId());
        profile = restTemplate.getForObject(baseURL + "/read/2", Profile.class);

        assertNull(profile);
    }

    @Test
    public void b_read() {
        ResponseEntity<Profile> profileResponseEntity = restTemplate.getForEntity(baseURL + "/read/2", Profile.class);
        assertNotNull(profileResponseEntity.getBody());
        assertEquals(2, profileResponseEntity.getBody().getProfileId());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ProfileHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}