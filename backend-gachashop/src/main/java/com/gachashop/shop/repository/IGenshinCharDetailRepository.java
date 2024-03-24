package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinCharacterDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinCharDetailRepository extends JpaRepository<GenshinCharacterDetail, Long> {
}
