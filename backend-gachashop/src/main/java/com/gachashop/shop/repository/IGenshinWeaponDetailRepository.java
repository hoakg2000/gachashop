package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinWeaponDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinWeaponDetailRepository extends JpaRepository<GenshinWeaponDetail, Long> {
}
