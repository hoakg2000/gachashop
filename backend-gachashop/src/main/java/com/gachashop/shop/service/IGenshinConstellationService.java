package com.gachashop.shop.service;

import com.gachashop.shop.model.GenshinConstellation;

import java.util.List;

public interface IGenshinConstellationService {
    GenshinConstellation getById(Long constellationId);

    List<GenshinConstellation> getAll();

    List<GenshinConstellation> getCharacterConstellation(Long characterId);

    GenshinConstellation create(Long characterId, GenshinConstellation genshinConstellation);

    GenshinConstellation update(Long characterId, Long constellationId, GenshinConstellation genshinConstellation);

    void delete(Long constellationId);

    void delete(Long characterId, Long constellationId);
}
