package com.iAxis.jumghor.user.service;

import com.iAxis.jumghor.user.entity.User;
import com.iAxis.jumghor.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iAxis.jumghor.user.entity.User.CACHE_NAME;

/**
 * @author aditya.chakma
 * @since 26 Apr, 2025
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Cacheable(cacheNames = CACHE_NAME)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Cacheable(cacheNames = CACHE_NAME)
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @CacheEvict(cacheNames = CACHE_NAME)
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

}
