package org.hulyam.service;

import lombok.RequiredArgsConstructor;
import org.hulyam.repository.IUserRepository;
import org.hulyam.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
