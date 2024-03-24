package com.gachashop.shop.service.impl;

import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.model.GenshinScamUID;
import com.gachashop.shop.repository.IGenshinScamUIDRepository;
import com.gachashop.shop.service.IGenshinScamUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenshinScamUIDService implements IGenshinScamUIDService {

    @Autowired
    IGenshinScamUIDRepository iGenshinScamUIDRepository;

    @Override
    public GenshinScamUID getById(long id) {
        Optional<GenshinScamUID> genshinScamUID = iGenshinScamUIDRepository.findById(id);
        if (genshinScamUID.isEmpty()) {
            throw new NotFoundException("Can't find");
        }
        return genshinScamUID.get();
    }

    @Override
    public List<GenshinScamUID> getAll() {
        List<GenshinScamUID> genshinScamUIDList = iGenshinScamUIDRepository.findAll();
        return genshinScamUIDList;
    }

    @Override
    public GenshinScamUID create(GenshinScamUID genshinScamUID) {
        if (this.getGenshinScamByUID(genshinScamUID.getUid()).isEmpty()) {
            return iGenshinScamUIDRepository.save(genshinScamUID);
        }
        return genshinScamUID;
    }

    @Override
    public GenshinScamUID update(long id, GenshinScamUID genshinScamUID) {
        Optional<GenshinScamUID> findDuplicate = iGenshinScamUIDRepository.findByUid(genshinScamUID.getUid());
        if (findDuplicate.isEmpty()) {
            return iGenshinScamUIDRepository.save(genshinScamUID);
        }
        return genshinScamUID;
    }

    @Override
    public GenshinScamUID findByUid(String uid) {
        Optional<GenshinScamUID> genshinScamUID = this.getGenshinScamByUID(uid);
        return genshinScamUID.get();
    }

    @Override
    public void delete(long id) {
        iGenshinScamUIDRepository.deleteById(id);
    }


    private Optional<GenshinScamUID> getGenshinScamByUID(String uid) {
        return iGenshinScamUIDRepository.findByUid(uid);
    }

}
