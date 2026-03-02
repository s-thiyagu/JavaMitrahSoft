package com.Practise.Spring.Boot.Security.service;

import com.Practise.Spring.Boot.Security.entity.UserInfo;
import com.Practise.Spring.Boot.Security.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {


    private final UserInfoRepository repository;

    private final PasswordEncoder encoder;


    public UserInfoService(UserInfoRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // Load user by email (used during authentication)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userInfo = repository.findByEmail(username);

        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        UserInfo user = userInfo.get();

        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(user.getRoles())
                )
        );
    }

    // Register new user
    public String addUser(UserInfo userInfo) {

        // Encode password before saving
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));

        repository.save(userInfo);

        return "User added successfully!";
    }
}