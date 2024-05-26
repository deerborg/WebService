package com.example.webservice.v1.controller;

import com.example.webservice.v1.core.result.ResultData;
import com.example.webservice.v1.dto.request.CreatedUserRequest;
import com.example.webservice.v1.dto.request.DisabledUserRequest;
import com.example.webservice.v1.dto.request.UpdateUserForSelfRequest;
import com.example.webservice.v1.dto.response.UserResponse;
import com.example.webservice.v1.model.User;
import com.example.webservice.v1.repository.UserRepository;
import com.example.webservice.v1.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/home")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/created")
    public ResultData<UserResponse> createUser(@RequestBody CreatedUserRequest user) {
        return userService.createdUser(user);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserResponse>> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    @PreAuthorize("#request.id == #user.id")
    public ResultData<UserResponse> updateUser(@RequestBody UpdateUserForSelfRequest request, @AuthenticationPrincipal User user){
        return userService.updateUser(request);
    }
    @GetMapping("/mail/{id}")
    public String getMail(@PathVariable Long id) {
        return userRepository.getUserByEmail(id);
    }
    @GetMapping("/admin")
    public String adminstrator(User user){
        return "Role :" + user.getRoles().toString();
    }
    @PutMapping("/disabled")
    public ResultData<UserResponse> disabledUser(@RequestBody DisabledUserRequest request){
        return userService.disabledUser(request);
    }
}
