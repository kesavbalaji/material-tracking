package com.power.project.service;

import com.power.project.dto.UserDto;
import com.power.project.entity.User;
import com.power.project.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email);
//        List<String> roles = Collections.singletonList(user.getRole());
        return
                org.springframework.security.core.userdetails.User.builder()
                        .username("kesav")
                        .password("balajee")
                        .roles("USER")
                        .build();
    }
}
