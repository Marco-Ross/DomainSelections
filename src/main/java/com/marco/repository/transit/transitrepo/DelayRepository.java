package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Delay;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface DelayRepository extends RepositoryGI<Delay, Integer> {
    Set<Delay> getAllDelays();
}
