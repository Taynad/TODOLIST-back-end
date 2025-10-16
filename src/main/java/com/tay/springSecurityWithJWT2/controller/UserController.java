package com.tay.springSecurityWithJWT2.controller;

import com.tay.springSecurityWithJWT2.dto.LoginResponse;
import com.tay.springSecurityWithJWT2.dto.TokenResponse;
import com.tay.springSecurityWithJWT2.dto.UserDTO;
import com.tay.springSecurityWithJWT2.security.JWTService;
import com.tay.springSecurityWithJWT2.security.UserAuthenticated;
import com.tay.springSecurityWithJWT2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    //métodos
    @PostMapping("/register")
    public ResponseEntity<String> save (@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginResponse loginResponse) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginResponse.getUsername(), loginResponse.getPassword());
        var authenticated = authenticationManager.authenticate(usernamePassword);
        var token = jwtService.generateToken((UserAuthenticated) authenticated.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }
}
