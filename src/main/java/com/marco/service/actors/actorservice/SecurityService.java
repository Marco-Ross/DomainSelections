package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Security;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public interface SecurityService extends ServiceGI<Security, Integer, Optional<Security>> {
    Set<Security> getAllSecurity();
}
