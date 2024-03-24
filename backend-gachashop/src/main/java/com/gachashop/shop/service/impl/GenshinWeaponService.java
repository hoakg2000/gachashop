package com.gachashop.shop.service.impl;

import com.gachashop.shop.model.GenshinWeapon;
import com.gachashop.shop.repository.IGenshinWeaponRepository;
import com.gachashop.shop.service.IGenshinWeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenshinWeaponService implements IGenshinWeaponService {

    @Autowired
    private IGenshinWeaponRepository weaponRepository;

    @Override
    public GenshinWeapon getById(long id) {
        Optional<GenshinWeapon> weaponOptional = weaponRepository.findById(id);
        return weaponOptional.orElse(null);
    }

    @Override
    public List<GenshinWeapon> getAll() {
        return weaponRepository.findAll();
    }

    @Override
    public GenshinWeapon create(GenshinWeapon weapon) {
        return weaponRepository.save(weapon);
    }

    @Override
    public GenshinWeapon update(long id, GenshinWeapon updatedWeapon) {
        Optional<GenshinWeapon> existingWeaponOptional = weaponRepository.findById(id);
        if (existingWeaponOptional.isPresent()) {
            GenshinWeapon existingWeapon = existingWeaponOptional.get();
            existingWeapon.setName(updatedWeapon.getName())
                    .setImageUrl(updatedWeapon.getImageUrl())
                    .setWeaponType(updatedWeapon.getWeaponType())
                    .setStar(updatedWeapon.getStar())
                    .setPassive(updatedWeapon.getPassive());
            return weaponRepository.save(existingWeapon);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        weaponRepository.deleteById(id);
    }
}
