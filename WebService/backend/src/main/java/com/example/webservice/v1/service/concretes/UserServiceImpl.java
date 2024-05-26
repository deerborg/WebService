package com.example.webservice.v1.service.concretes;

import com.example.webservice.v1.core.config.modelMapper.ModelMapperService;
import com.example.webservice.v1.core.exception.NotFoundIdException;
import com.example.webservice.v1.core.exception.NotUniqueValues;
import com.example.webservice.v1.core.result.ResultData;
import com.example.webservice.v1.core.utilites.ResultHelper;
import com.example.webservice.v1.dto.request.CreatedUserRequest;
import com.example.webservice.v1.dto.request.DisabledUserRequest;
import com.example.webservice.v1.dto.request.UpdateUserForSelfRequest;
import com.example.webservice.v1.dto.response.UserResponse;
import com.example.webservice.v1.model.User;
import com.example.webservice.v1.repository.UserRepository;
import com.example.webservice.v1.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder encoder;

    @Override
    public ResultData<UserResponse> createdUser(CreatedUserRequest createdUserRequest) {
        if(userRepository.existsUserByEmail(createdUserRequest.getEmail())){
            throw new NotUniqueValues();
        }
        createdUserRequest.setPassword(encoder.encode(createdUserRequest.getPassword()));
        return ResultHelper.CREATED(modelMapperService.forResponse().map(userRepository.save(modelMapperService.forRequest().map(createdUserRequest, User.class)), UserResponse.class));
    }

    @Override
    public ResponseEntity<Optional<UserResponse>> getUserById(Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new NotFoundIdException();
        }
        return ResponseEntity.ok(userRepository.findById(id).map(user -> modelMapperService.forResponse().map(user, UserResponse.class)));
    }

    @Override
    public User getByUsername(String username) {
         return userRepository.findByUsername(username);
    }

    @Override
    public ResultData<UserResponse> updateUser(UpdateUserForSelfRequest updateUserForSelfRequest) {
        if(userRepository.findById(updateUserForSelfRequest.getId()).isEmpty()){
            throw new NotFoundIdException();
        }
        updateUserForSelfRequest.setPassword(encoder.encode(updateUserForSelfRequest.getPassword()));
        return ResultHelper.CREATED(modelMapperService.forResponse().map(userRepository.save(modelMapperService.forRequest().map(updateUserForSelfRequest,User.class)),UserResponse.class));
    }

    @Override
    public ResultData<UserResponse> disabledUser(DisabledUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(()-> new NotFoundIdException());
        user.setEnabled(false);
        return ResultHelper.CREATED(modelMapperService.forResponse().map(userRepository.save(user),UserResponse.class));
    }
}
