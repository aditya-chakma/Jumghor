package com.iAxis.jumghor.repository;

import com.iAxis.jumghor.entities.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 3:24 PM
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
