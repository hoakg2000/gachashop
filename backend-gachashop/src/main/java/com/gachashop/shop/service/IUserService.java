package com.gachashop.shop.service;

import com.gachashop.shop.dto.request.CreateUserRequestDTO;
import com.gachashop.shop.dto.response.UserResponseDTO;

import java.util.List;

public interface IUserService {
    UserResponseDTO getUserById(int id) throws Exception;

    List<UserResponseDTO> getAllUser();

    UserResponseDTO createUser(CreateUserRequestDTO user);

    UserResponseDTO updateUser(int id, CreateUserRequestDTO user);

    void deleteUser(int id);
}
