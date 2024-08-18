package com.arshad.blogapi.users;


import com.arshad.blogapi.common.dtos.ErrorResponse;
import com.arshad.blogapi.users.dtos.CreateUserRequest;
import com.arshad.blogapi.users.dtos.UserResponse;

import com.arshad.blogapi.users.dtos.LoginUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final ModelMapper modelMapper;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    ResponseEntity<UserResponse> signupUser(@RequestBody CreateUserRequest request) {
        UserEntity savedUser =  usersService.createUser(request);
        //URI savedUserUri = URI.create("/users/" + savedUser.getId());
        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);

        return ResponseEntity.accepted()
                .body(userResponse);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserRequest request) throws IllegalArgumentException{
        UserEntity savedUser =  usersService.loginUser(request.getUsername(), request.getPassword());

        return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }


    @ExceptionHandler({
            UsersService.UserNotFoundException.class
    })
    ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex) {
        String message;
        HttpStatus status;

        if (ex instanceof UsersService.UserNotFoundException) {
            message = ex.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(ex instanceof IllegalArgumentException){
            message = ex.getMessage();
            status = HttpStatus.NOT_FOUND;
        }else {
            message = "Something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorResponse response = new ErrorResponse(message);

        return ResponseEntity.status(status).body(response);
    }
}