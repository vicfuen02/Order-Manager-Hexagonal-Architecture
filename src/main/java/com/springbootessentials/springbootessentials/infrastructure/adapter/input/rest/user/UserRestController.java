package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.user;


import com.springbootessentials.springbootessentials.application.service.user.UserServiceImpl;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper.UserRestControllerMapper;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.user.dto.UserReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserRestController extends UserExceptionHandler {


    private UserServiceImpl userService;

    private PasswordEncoder passwordEncoder;

    private UserRestControllerMapper userRestControllerMapper;



    @Autowired
    public UserRestController(UserServiceImpl userService, PasswordEncoder passwordEncoder, UserRestControllerMapper userRestControllerMapper) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userRestControllerMapper = userRestControllerMapper;
    }


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserReqDTO user) {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userService.createUser(this.userRestControllerMapper.toBDTO(user));

        return ResponseEntity.ok("User created");
    }

    @GetMapping
    public String getUsersDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "ok";
    }



}
