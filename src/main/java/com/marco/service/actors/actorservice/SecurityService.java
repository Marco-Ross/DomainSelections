package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Security;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Set;

public interface SecurityService extends ServiceGI<Security, Integer> {
    Set<Security> getAllSecurity();
}
