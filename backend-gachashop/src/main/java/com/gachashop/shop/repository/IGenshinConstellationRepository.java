package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinConstellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinConstellationRepository extends JpaRepository<GenshinConstellation, Long> {
}