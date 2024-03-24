package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinWeaponRepository extends JpaRepository<GenshinWeapon, Long> {
}
