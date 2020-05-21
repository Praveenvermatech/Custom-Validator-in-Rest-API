package com.developervisits.controller;

import com.developervisits.model.UserDetailModel;
import com.developervisits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {
    @Autowired(required = true)
    private UserService service;

    public void UserController(UserService service){
        this.service = service;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDetailModel> createUser(@Valid @RequestBody UserDetailModel requestUserDetails) {

        UserDetailModel model = service.saveUser(requestUserDetails);

        return ResponseEntity.ok( model);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDetailModel>> getUSerList(){
        List<UserDetailModel> model = service.retrieveUsers();
        return ResponseEntity.ok(model);
    }

    // Handle Error

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(cv -> {
            errors.put("message", cv.getMessage());
            errors.put("path", (cv.getPropertyPath()).toString());
        });

        return errors;
    }


}
