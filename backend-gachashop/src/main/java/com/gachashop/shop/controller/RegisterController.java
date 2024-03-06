package com.gachashop.shop.controller;

import com.gachashop.shop.dto.response.ResponseDTO;
import com.gachashop.shop.model.RegistrationUser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RegistrationUser registrationUser) {
        return null;
    }

    @PostMapping("/confirm/:id")
    public ResponseEntity<ResponseDTO> confirmRegister(@RequestParam int id) {
        return null;
    }
}
