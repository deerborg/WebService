package com.example.webservice.v1.service.abstracts;

import com.example.webservice.v1.core.result.ResultData;
import com.example.webservice.v1.dto.request.CreatedUserRequest;
import com.example.webservice.v1.dto.request.DisabledUserRequest;
import com.example.webservice.v1.dto.request.UpdateUserForSelfRequest;
import com.example.webservice.v1.dto.response.UserResponse;
import com.example.webservice.v1.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    ResultData<UserResponse> createdUser(CreatedUserRequest createdUserRequest);
    ResponseEntity<Optional<UserResponse>> getUserById(Long id);
    User getByUsername(String username);
    ResultData<UserResponse> updateUser(UpdateUserForSelfRequest updateUserForSelfRequest);
    ResultData<UserResponse> disabledUser(DisabledUserRequest request);
}
