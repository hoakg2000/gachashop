package com.gachashop.shop.service.impl;

import com.gachashop.shop.model.Scammer;
import com.gachashop.shop.repository.IScammerRepository;
import com.gachashop.shop.service.IScammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScammerService implements IScammerService {

    @Autowired
    private IScammerRepository scammerRepository;

    @Override
    public Scammer getById(long id) {
        Optional<Scammer> scammer = scammerRepository.findById(id);
        return scammer.orElse(null);
    }

    @Override
    public List<Scammer> getAll() {
        return scammerRepository.findAll();
    }

    @Override
    public Scammer create(Scammer scammer) {
        return scammerRepository.save(scammer);
    }

    @Override
    public Scammer update(long id, Scammer updatedScammer) {
        Optional<Scammer> existingScammerOptional = scammerRepository.findById(id);
        if (existingScammerOptional.isPresent()) {
            Scammer existingScammer = existingScammerOptional.get();
            updatedScammer.setId(existingScammer.getId());
            return scammerRepository.save(updatedScammer);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        scammerRepository.deleteById(id);
    }
}
