package com.gachashop.shop.service;

import com.gachashop.shop.dto.request.LoginRequestDTO;
import com.gachashop.shop.dto.response.UserResponseDTO;

public interface IAuthService {
    UserResponseDTO login(LoginRequestDTO userRequestDTO);
}
