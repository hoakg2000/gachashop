package com.gachashop.shop.repository;

import com.gachashop.shop.model.Scammer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScammerRepository extends JpaRepository<Scammer, Long> {
}
