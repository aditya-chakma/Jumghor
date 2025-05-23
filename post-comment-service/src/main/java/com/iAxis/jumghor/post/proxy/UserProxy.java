package com.iAxis.jumghor.post.proxy;

import com.iAxis.jumghor.entities.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aditya.chakma
 * @since 15 May, 2025 11:51 AM
 */
@FeignClient(name = "user-service", path = "/v1/users")
public interface UserProxy {

    @GetMapping("/{userId}")
    UserDto getUser(@PathVariable Long userId);

}
