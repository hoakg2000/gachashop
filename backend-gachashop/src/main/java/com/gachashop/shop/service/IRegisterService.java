package com.gachashop.shop.service;

import com.gachashop.shop.datatype.Status;
import com.gachashop.shop.dto.response.UserResponseDTO;
import com.gachashop.shop.model.RegistrationUser;

import java.util.List;

public interface IRegisterService {

    String register(RegistrationUser registrationUser);

    List<RegistrationUser> getAll();

    List<RegistrationUser> getByStatus(Status status);

    UserResponseDTO confirm(Long id);
}
