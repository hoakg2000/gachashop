package com.gachashop.shop.service;

import com.gachashop.shop.model.GenshinCharacter;
import com.gachashop.shop.model.GenshinConstellation;

public interface IGenshinCharacterService extends ICrudService<GenshinCharacter, GenshinCharacter> {
    GenshinCharacter addConstellation(Long characterId, GenshinConstellation genshinConstellation);

    GenshinCharacter removeConstellation(Long characterId, Long constellationid);

}
