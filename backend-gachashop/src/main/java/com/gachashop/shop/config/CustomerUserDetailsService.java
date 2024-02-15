package com.gachashop.shop.config;

import com.gachashop.shop.model.AuthUserDetails;
import com.gachashop.shop.model.User;
import com.gachashop.shop.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerUserDetailsService implements UserDetailsService {

    private final IUserRepository iUserRepository;

    public CustomerUserDetailsService(IUserRepository userRepository) {
        this.iUserRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = iUserRepository.findByUsername(username);
        return userInfo.map(AuthUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
