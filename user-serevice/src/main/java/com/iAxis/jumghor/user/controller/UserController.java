package com.iAxis.jumghor.user.controller;

import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.User;
import com.iAxis.jumghor.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 3:16 PM
 */
@RestController
@RequestMapping("/v1/u")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return userService.findAll().stream().map(UserDto::new).toList();
    }

    @GetMapping("/profile/{user_id}")
    public UserDto getUser(@PathVariable("user_id") long id) {
        User user = userService.findById(id);

        if (Objects.isNull(user)) {
            return null;
        }

        return new UserDto(user);
    }

    @PostMapping("/profile")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userDto.toUser();
        userService.saveOrUpdate(user);
        return new UserDto(user);
    }

    @PatchMapping("/profile")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userDto.toUser();
        User oldUser = userService.findByUserName(user.getUserName());

        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setDisplayName(user.getDisplayName());

        userService.saveOrUpdate(oldUser);

        return new UserDto(user);
    }

//    @PatchMapping("/friend/{user_id}/{friend_id}")
//    public UserDto addUser(@PathVariable("user_id") long userId, @PathVariable("friend_id") long friendId) {
//        User user = userService.findById(userId);
//        User friend = userService.findById(friendId);
//
//
//    }

}
