package com.gachashop.shop.service.impl;

import com.gachashop.shop.ExceptionHandler.exception.NotFoundException;
import com.gachashop.shop.datatype.Status;
import com.gachashop.shop.dto.response.UserResponseDTO;
import com.gachashop.shop.model.RegistrationUser;
import com.gachashop.shop.model.User;
import com.gachashop.shop.repository.IRegisterRepository;
import com.gachashop.shop.repository.IUserRepository;
import com.gachashop.shop.service.IRegisterService;
import com.gachashop.shop.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    private IRegisterRepository iRegisterRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public String register(RegistrationUser registrationUser) {
        List<RegistrationUser> pendingList = iRegisterRepository.findAllByStatus(Status.PENDING);
        if (!isEmailAlreadyExists(registrationUser.getEmail(), pendingList)) {
            iRegisterRepository.save((registrationUser));
        }
        return "ok";
    }

    @Override
    public List<RegistrationUser> getAll() {
        return iRegisterRepository.findAll();
    }

    @Override
    public List<RegistrationUser> getByStatus(Status status) {
        return iRegisterRepository.findAllByStatus(status);
    }

    @Override
    public UserResponseDTO confirm(Long id) {
        Optional<RegistrationUser> optionalRegistrationUser = iRegisterRepository.findById(id);
        if (optionalRegistrationUser.isEmpty()) {
            throw new NotFoundException("Can't find registration with id: " + id);
        }
        RegistrationUser registrationUser = optionalRegistrationUser.get();

        String randomPassword = RandomGenerator.generateRandomPassword();

        User user = new User().setUsername(registrationUser.getUsername())
                .setEmail(registrationUser.getEmail())
                .setFacebook(registrationUser.getFacebook())
                .setPassword(randomPassword);
        iUserRepository.save(user);

        return new UserResponseDTO(user);
    }

    private boolean isEmailAlreadyExists(String email, List<RegistrationUser> userList) {
        for (RegistrationUser user : userList) {
            if (user.getEmail().equals(email)) {
                return true; // Email already exists in the list
            }
        }
        return false; // Email does not exist in the list
    }
}
