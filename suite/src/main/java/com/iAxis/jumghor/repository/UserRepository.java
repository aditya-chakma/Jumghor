package com.iAxis.jumghor.repository;

import com.iAxis.jumghor.entities.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 3:24 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
