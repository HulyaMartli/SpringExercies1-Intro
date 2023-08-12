package org.hulyam.controller;

import lombok.RequiredArgsConstructor;
import org.hulyam.dto.request.UserSaveRequestDto;
import org.hulyam.dto.response.UserFindAllResponseDto;
import org.hulyam.repository.entity.User;
import org.hulyam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.hulyam.constant.EndPoints.*;

@RestController
@RequestMapping(API + VERSION + USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(SAVE)
    public ResponseEntity<String> save(UserSaveRequestDto dto) {
        userService.saveDto(dto);
        return ResponseEntity.ok("Save is successful!");
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<UserFindAllResponseDto>> findAll() {
        return ResponseEntity.ok((List<UserFindAllResponseDto>) userService.findAllResponseDto());
    }

    // HTML & CSS example
    @GetMapping(HI)
    public String hi() {
        return "<h1 style=\"color:red\">Hi!</h1>";
    }

    // http://localhost:9090/user/findbyname?name=Hulya
    @GetMapping(FINDBYNAME)
    public ResponseEntity<User> findByName(String name) {
        return ResponseEntity.ok(userService.findByName(name)
        );
    }

    @GetMapping(FINDBYADDRESS)
    public ResponseEntity<User> findByAddress(String address) {
        return ResponseEntity.ok(userService.findByAddress(address));
    }

    @GetMapping(FINDBYNAMEANDADDRESS)
    public ResponseEntity<User> findByNameAndAddress(String name, String address) {
        return ResponseEntity.ok(userService.findByNameAndAddress(name, address));
    }

    @GetMapping(FINDBYNAMEORADDRESS)
    public ResponseEntity<List<User>> findByNameOrAddress(String name, String address) {
        return ResponseEntity.ok(userService.findByNameOrAddress(name, address));
    }

    @GetMapping(FINDBYNAMEANDADDRESSANDTEL)
    public ResponseEntity<User> findByNameAndAddressAndTel(String name, String address, String tel) {
        return ResponseEntity.ok(userService.findByNameAndAddressAndTel(name, address, tel));
    }

    @GetMapping(FINDALLBYCITY)
    public ResponseEntity<List<User>> findAllByCity(String city) {
        return ResponseEntity.ok(userService.findAllByCity(city));
    }

    @GetMapping(FINDALLBYNAMESTARTSWITH)
    public List<User> findAllByNameStartsWith(String word) {
        return userService.findAllByNameStartsWith(word);
    }

    @GetMapping(FINDOPTIONALBYNAMEANDTEL)
    public Optional<User> findOptionalByNameAndTel(String name, String tel) {
        return userService.findOptionalByNameAndTel(name, tel);
    }

    @GetMapping(FINDALLBYNAMEORDERBYIDDESC)
    public List<User> findAllByNameOrderByIdDesc(String name) {
        return userService.findAllByNameOrderByIdDesc(name);
    }

    @GetMapping(FINDTOP3BYNAMEORDERBYID)
    public List<User> findTop3ByNameOrderById(String name) {
        return userService.findTop3ByNameOrderById(name);
    }
}
