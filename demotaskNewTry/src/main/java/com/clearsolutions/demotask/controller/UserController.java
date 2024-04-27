package com.clearsolutions.demotask.controller;

import com.clearsolutions.demotask.domain.User;
import com.clearsolutions.demotask.dto.RegisterRequest;
import com.clearsolutions.demotask.dto.UpdateUserRequest;
import com.clearsolutions.demotask.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody RegisterRequest registerRequest) throws Exception {
        return userService.register(registerRequest);
    }

    @GetMapping("/byBirthDateRange")
    public List<User> findUsersByAgeLessThan(@RequestParam("fromDate") Date fromDate, @RequestParam("toDate") Date toDate){
        List<User> users = userService.findUsersByDateBetween(fromDate,toDate);
        return users;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest updateUserRequest){
        userService.update(id, updateUserRequest);
        return "Seccussfuly";
    }


}
