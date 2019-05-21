package com.marco.repository.transit.impl;

import com.marco.domain.transit.Delay;
import com.marco.repository.transit.transitrepo.DelayRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("DelayRepoImpl")
public class DelayRepositoryImpl implements DelayRepository {
    private Map<Integer, Delay> delays;

    private DelayRepositoryImpl(){
        this.delays = new HashMap<>();
    }

    @Override
    public Set<Delay> getAllDelays() {
        Collection<Delay> platforms = this.delays.values();
        Set<Delay> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public Delay create(Delay delay) {
        this.delays.put(delay.getDelayId(), delay);
        return this.delays.get(delay.getDelayId());
    }

    @Override
    public Delay update(Delay delay) {
        this.delays.replace(delay.getDelayId(), delay);
        return this.delays.get(delay.getDelayId());
    }

    @Override
    public void delete(Integer delayId) {
        this.delays.remove(delayId);
    }

    @Override
    public Delay read(Integer delayId) {
        return this.delays.get(delayId);
    }
}
