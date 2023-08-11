package org.hulyam.controller;

import lombok.RequiredArgsConstructor;
import org.hulyam.repository.entity.User;
import org.hulyam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/save")
    public ResponseEntity<User> save(String name, String city, String address, String tel) {
        return ResponseEntity.ok(userService.save(
                User.builder().name(name).city(city).address(address).tel(tel).build()
        ));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok((List<User>) userService.findAll());
    }

    @GetMapping("/hi")
    public String hi() {
        return "<h1 style=\"color:red\">Hi!</h1>";
    }

    // http://localhost:9090/user/findbyname?name=Hulya
    @GetMapping("/findbyname")
    public ResponseEntity<User> findByName(String name) {
        return ResponseEntity.ok(userService.findByName(name)
        );
    }

    @GetMapping("/findbyaddress")
    public ResponseEntity<User> findByAddress(String address) {
        return ResponseEntity.ok(userService.findByAddress(address));
    }

    @GetMapping("/findbynameandaddress")
    public ResponseEntity<User> findByNameAndAddress(String name, String address) {
        return ResponseEntity.ok(userService.findByNameAndAddress(name, address));
    }

    @GetMapping("/findbynameoraddress")
    public ResponseEntity<List<User>> findByNameOrAddress(String name, String address) {
        return ResponseEntity.ok(userService.findByNameOrAddress(name, address));
    }

    @GetMapping("/findbynameandaddressandtel")
    public ResponseEntity<User> findByNameAndAddressAndTel(String name, String address, String tel) {
        return ResponseEntity.ok(userService.findByNameAndAddressAndTel(name, address, tel));
    }

    @GetMapping("/findallbycity")
    public ResponseEntity<List<User>> findAllByCity(String city) {
        return ResponseEntity.ok(userService.findAllByCity(city));
    }

    @GetMapping("/findallbynamestartswith")
    public List<User> findAllByNameStartsWith(String word){
        return userService.findAllByNameStartsWith(word);
    }

    @GetMapping("/findoptionalbynameandtel")
    public Optional<User> findOptionalByNameAndTel(String name, String tel){
        return userService.findOptionalByNameAndTel(name, tel);
    }

    @GetMapping("/findallbynameorderbyiddesc")
    public List<User> findAllByNameOrderByIdDesc(String name){
        return userService.findAllByNameOrderByIdDesc(name);
    }

    @GetMapping("/findtop3bynameorderbyid")
    public List<User> findTop3ByNameOrderByName(String name){
        return userService.findTop3ByNameOrderById(name);
    }
}
