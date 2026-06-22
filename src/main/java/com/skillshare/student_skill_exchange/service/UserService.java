package com.skillshare.student_skill_exchange.service;

import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User registerUser(User user){

        System.out.println("Inside UserService");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        System.out.println("Saved user ID = " + savedUser.getId());

        return savedUser;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
}
