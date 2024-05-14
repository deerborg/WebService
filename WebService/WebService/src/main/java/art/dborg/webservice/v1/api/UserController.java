package art.dborg.webservice.v1.api;

import art.dborg.webservice.v1.business.abstracts.UserService;
import art.dborg.webservice.v1.core.config.modelMapper.ModelMapperService;
import art.dborg.webservice.v1.core.result.ResultData;
import art.dborg.webservice.v1.core.utilites.ResultHelper;
import art.dborg.webservice.v1.dto.request.UserSaveRequest;
import art.dborg.webservice.v1.dto.response.UserResponse;
import art.dborg.webservice.v1.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final ModelMapperService modelMapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<UserResponse> createUser(@Valid @RequestBody UserSaveRequest userSaveRequest){
        return ResultHelper.CREATED(modelMapperService.forResponse().map(userService.save(modelMapperService.forRequest().map(userSaveRequest,User.class)),UserResponse.class));
    }

}
