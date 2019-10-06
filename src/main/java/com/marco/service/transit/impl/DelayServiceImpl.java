package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Delay;
import com.marco.repository.transit.transitrepo.DelayRepository;
import com.marco.service.transit.transitservice.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("DelayServiceImpl")
public class DelayServiceImpl implements DelayService {
    @Autowired
    private DelayRepository repository;

    @Override
    public Set<Delay> getAllDelays() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Delay create(Delay delay) {
        return this.repository.save(delay);
    }

    @Override
    public Delay update(Delay delay) {
        return this.repository.save(delay);
    }

    @Override
    public void delete(Integer delay) {
        this.repository.deleteById(delay);
    }

    @Override
    public Optional<Delay> read(Integer delay) {
        return this.repository.findById(delay);
    }
}
