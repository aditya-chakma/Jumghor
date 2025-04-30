package com.iAxis.jumghor.relation_service.proxy;

import com.iAxis.jumghor.entities.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@FeignClient(name = "user-service", path = "/v1/u")
public interface UserProxy {

    @GetMapping("/profile/{user_id}")
    UserDto getUser(@PathVariable long user_id);

}
