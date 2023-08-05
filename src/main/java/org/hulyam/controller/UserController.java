package org.hulyam.controller;

import lombok.RequiredArgsConstructor;
import org.hulyam.repository.entity.User;
import org.hulyam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/save")
    public ResponseEntity<User> save(String name, String address) {
        return ResponseEntity.ok(userService.save(
                User.builder().name(name).address(address).build()
        ));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
