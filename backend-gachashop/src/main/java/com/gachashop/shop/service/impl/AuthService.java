package com.gachashop.shop.service.impl;

import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.config.jwt.JwtUtilities;
import com.gachashop.shop.dto.request.LoginRequestDTO;
import com.gachashop.shop.dto.response.UserResponseDTO;
import com.gachashop.shop.model.User;
import com.gachashop.shop.repository.IUserRepository;
import com.gachashop.shop.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtilities jwtUtilities;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserResponseDTO login(LoginRequestDTO userRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequestDTO.getUsername(),
                            userRequestDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = iUserRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> new NotFoundException("User not found"));

            String token = jwtUtilities.generateToken(user.getUsername(), user.getRole());

            return new UserResponseDTO(user, token);
        } catch (AuthenticationException authenticationException) {
            throw new NotFoundException("Incorrect username or password");
        }


    }
}
