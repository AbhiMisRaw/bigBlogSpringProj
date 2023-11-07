package com.abhimisraw.BigBlog.service;

import com.abhimisraw.BigBlog.domain.User;
import com.abhimisraw.BigBlog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserForm userForm){
        User user = userForm.toUser(userForm);
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);
    }

}
