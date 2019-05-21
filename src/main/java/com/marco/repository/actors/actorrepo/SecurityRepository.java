package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Security;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface SecurityRepository extends RepositoryGI<Security, Integer> {
    Set<Security> getAllSecurity();
}
