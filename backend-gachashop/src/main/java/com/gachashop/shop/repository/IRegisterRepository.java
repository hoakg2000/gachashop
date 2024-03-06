package com.gachashop.shop.repository;

import com.gachashop.shop.datatype.Status;
import com.gachashop.shop.model.RegistrationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRegisterRepository extends JpaRepository<RegistrationUser, Long> {
    List<RegistrationUser> findAllByStatus(Status status);
}
