package com.marco.repository.repositoryinterfaces.actorrepo;

import com.marco.domain.actors.Security;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface SecurityRepository extends RepositoryGI<Security, Integer> {
    ArrayList<Security> getAllSecurity();
}
