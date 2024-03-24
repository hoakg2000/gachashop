package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinScamUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGenshinScamUIDRepository extends JpaRepository<GenshinScamUID, Long> {
    Optional<GenshinScamUID> findByUid(String uid);
}
