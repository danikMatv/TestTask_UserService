package com.clearsolutions.demotask.service;

import com.clearsolutions.demotask.exception.EmptyParam;
import com.clearsolutions.demotask.exception.InvalidAgeException;
import com.clearsolutions.demotask.exception.UserNotFound;
import com.clearsolutions.demotask.mapper.UserMapper;
import com.clearsolutions.demotask.domain.User;
import com.clearsolutions.demotask.dto.RegisterRequest;
import com.clearsolutions.demotask.dto.UpdateUserRequest;
import com.clearsolutions.demotask.repository.UserRepository;
import com.clearsolutions.demotask.validator.AgeValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${validation.age}")
    private int age;
    @Transactional
    public String register(RegisterRequest registerRequest) throws Exception {

        if(!AgeValidator.isValidAge(registerRequest.getDate(), age)){
            throw new InvalidAgeException("Invalid age"); //TODO create and add custom Exception for age - done
        }
        User user = userMapper.map(registerRequest);
        userRepository.save(user);
        return "Successfuly";
    }

    @Transactional
    public String update(Long id, UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFound("User not found by " + id)); //TODO create and add custom Exception - done
        User newUser = userRepository.save(userMapper.updateUser(user,updateUserRequest));
        return "Successfuly";
    }

    @Transactional
    public String delete(Long id){
        userRepository.deleteById(id);
        return "Seccessfuly";
    }

    public List<User> findUsersByDateBetween(Date fromDate, Date toDate){
        if (fromDate != null || toDate == null || fromDate.after(toDate)){
            throw new EmptyParam("Param nt found");
        }
        List<User> users = userRepository.findUsersByDateBetween(fromDate,toDate);
        return users;
    }

}
