package com.marco.service.transit.impl;

import com.marco.domain.transit.Delay;
import com.marco.repository.transit.impl.DelayRepositoryImpl;
import com.marco.repository.transit.transitrepo.DelayRepository;
import com.marco.service.transit.transitservice.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("DelayServiceImpl")
public class DelayServiceImpl implements DelayService {
    @Autowired
    @Qualifier("DelayRepoImpl")
    private DelayRepository repository;

    @Override
    public Set<Delay> getAllDelays() {
        return this.repository.getAllDelays();
    }

    @Override
    public Delay create(Delay delay) {
        return this.repository.create(delay);
    }

    @Override
    public Delay update(Delay delay) {
        return this.repository.update(delay);
    }

    @Override
    public void delete(Integer delay) {
        this.repository.delete(delay);
    }

    @Override
    public Delay read(Integer delay) {
        return this.repository.read(delay);
    }
}
