package com.gachashop.shop.repository;

import com.gachashop.shop.model.GenshinAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenshinAccountRepository extends JpaRepository<GenshinAccount, Long> {
}
