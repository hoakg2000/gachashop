package com.gachashop.shop.repository;

import com.gachashop.shop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Long> {
}
