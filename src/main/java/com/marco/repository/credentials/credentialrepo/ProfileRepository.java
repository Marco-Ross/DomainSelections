package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.Profile;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
