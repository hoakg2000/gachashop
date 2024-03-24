package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinCharacterRepository extends JpaRepository<GenshinCharacter, Long> {
}