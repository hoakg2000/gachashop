package com.gachashop.shop.service;

import com.gachashop.shop.model.GenshinScamUID;

public interface IGenshinScamUIDService extends ICrudService<GenshinScamUID, GenshinScamUID> {
    GenshinScamUID findByUid(String uid);
}
