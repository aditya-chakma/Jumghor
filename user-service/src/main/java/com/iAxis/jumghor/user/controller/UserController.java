package com.iAxis.jumghor.user.controller;

import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.user.entity.User;
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
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll().stream().map(User::to).toList();
    }

    @GetMapping("/{user_id}")
    public UserDto getUser(@PathVariable("user_id") long id) {
        User user = userService.findById(id);

        if (Objects.isNull(user)) {
            return null;
        }

        return user.to();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = User.from(userDto);
        userService.saveOrUpdate(user);
        return user.to();
    }

    @PatchMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = User.from(userDto);
        User oldUser = userService.findByUserName(user.getUserName());

        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setDisplayName(user.getDisplayName());

        userService.saveOrUpdate(oldUser);

        return oldUser.to();
    }

//    @PatchMapping("/friend/{user_id}/{friend_id}")
//    public UserDto addUser(@PathVariable("user_id") long userId, @PathVariable("friend_id") long friendId) {
//        User user = userService.findById(userId);
//        User friend = userService.findById(friendId);
//
//
//    }

}
