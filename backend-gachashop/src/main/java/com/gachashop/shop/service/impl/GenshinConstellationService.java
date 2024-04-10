package com.gachashop.shop.service.impl;

import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.model.GenshinCharacter;
import com.gachashop.shop.model.GenshinConstellation;
import com.gachashop.shop.repository.IGenshinConstellationRepository;
import com.gachashop.shop.service.IGenshinConstellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenshinConstellationService implements IGenshinConstellationService {


    @Autowired
    private IGenshinConstellationRepository genshinConstellationRepository;

    @Autowired
    private GenshinCharacterService genshinCharacterService;

    @Override
    public GenshinConstellation getById(Long constellationId) {
        Optional<GenshinConstellation> optionalGenshinConstellation = genshinConstellationRepository.findById(constellationId);
        if (optionalGenshinConstellation.isEmpty()) {
            throw new NotFoundException("Can't find constelation with id " + constellationId);
        }
        return optionalGenshinConstellation.get();
    }

    @Override
    public List<GenshinConstellation> getAll() {
        return genshinConstellationRepository.findAll();
    }

    @Override
    public List<GenshinConstellation> getCharacterConstellation(Long characterId) {
        GenshinCharacter genshinCharacter = genshinCharacterService.getById(characterId);
        return genshinCharacter.getConstellations();
    }

    @Override
    public GenshinConstellation create(Long characterId, GenshinConstellation genshinConstellation) {
        GenshinCharacter genshinCharacter = genshinCharacterService.getById(characterId);
        genshinConstellation.setGenshinCharacter(genshinCharacter);
        return genshinConstellationRepository.save(genshinConstellation);
    }

    @Override
    public GenshinConstellation update(Long characterId, Long constellationId, GenshinConstellation genshinConstellation) {
        GenshinCharacter genshinCharacter = genshinCharacterService.getById(characterId);
        GenshinConstellation existedConstellation = this.getById(constellationId);
        existedConstellation.setGenshinCharacter(genshinCharacter)
                .setName(genshinConstellation.getName())
                .setImageUrl(genshinConstellation.getImageUrl())
                .setDetail(genshinConstellation.getDetail())
                .setId(constellationId);
        return genshinConstellationRepository.save(existedConstellation);
    }

    @Override
    public void delete(Long constellationId) {
        genshinConstellationRepository.deleteById(constellationId);
    }

    @Override
    public void delete(Long characterId, Long constellationId) {
        GenshinCharacter genshinCharacter = genshinCharacterService.getById(characterId);
        genshinCharacter.getConstellations().remove(constellationId);
        genshinCharacterService.update(characterId, genshinCharacter);
    }

}