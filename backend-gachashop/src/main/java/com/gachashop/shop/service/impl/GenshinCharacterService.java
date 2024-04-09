package com.gachashop.shop.service.impl;

import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.ExceptionHandler.exception.UniqueEntityException;
import com.gachashop.shop.model.GenshinCharacter;
import com.gachashop.shop.repository.IGenshinCharacterRepository;
import com.gachashop.shop.service.IGenshinCharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenshinCharacterService implements IGenshinCharacterService {

    @Autowired
    private IGenshinCharacterRepository genshinCharacterRepository;

    @Override
    @Transactional(readOnly = true)
    public GenshinCharacter getById(long id) throws NotFoundException {
        return genshinCharacterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("GenshinCharacter not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenshinCharacter> getAll() {
        return genshinCharacterRepository.findAll();
    }

    @Override
    @Transactional
    public GenshinCharacter create(@Valid GenshinCharacter genshinCharacter) throws UniqueEntityException {
        return genshinCharacterRepository.save(genshinCharacter);
    }

    @Override
    @Transactional
    public GenshinCharacter update(long id, @Valid GenshinCharacter genshinCharacter) throws NotFoundException {
        GenshinCharacter existingCharacter = getById(id); // Ensure character exists before updating
        existingCharacter.setName(genshinCharacter.getName()); // Update fields as needed
        existingCharacter.setElement(genshinCharacter.getElement());
        existingCharacter.setWeapon(genshinCharacter.getWeapon());
        existingCharacter.setStar(genshinCharacter.getStar());
        // Constellations update separated;
        return genshinCharacterRepository.save(existingCharacter); // Persist changes
    }

    @Override
    @Transactional
    public void delete(long id) throws NotFoundException {
        GenshinCharacter characterToDelete = getById(id); // Ensure character exists before deleting
        genshinCharacterRepository.delete(characterToDelete);
    }
}