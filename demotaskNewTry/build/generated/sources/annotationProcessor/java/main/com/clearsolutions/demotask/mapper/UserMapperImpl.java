package com.clearsolutions.demotask.mapper;

import com.clearsolutions.demotask.domain.User;
import com.clearsolutions.demotask.dto.RegisterRequest;
import com.clearsolutions.demotask.dto.UpdateUserRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-25T20:49:38+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User updateUser(User user, UpdateUserRequest updateUserRequest) {
        if ( updateUserRequest == null ) {
            return user;
        }

        if ( updateUserRequest.getFirstName() != null ) {
            user.setFirstName( updateUserRequest.getFirstName() );
        }
        if ( updateUserRequest.getLastName() != null ) {
            user.setLastName( updateUserRequest.getLastName() );
        }
        if ( updateUserRequest.getEmail() != null ) {
            user.setEmail( updateUserRequest.getEmail() );
        }
        if ( updateUserRequest.getAddress() != null ) {
            user.setAddress( updateUserRequest.getAddress() );
        }
        if ( updateUserRequest.getPhoneNumber() != null ) {
            user.setPhoneNumber( updateUserRequest.getPhoneNumber() );
        }

        return user;
    }

    @Override
    public User map(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( registerRequest.getFirstName() );
        user.setLastName( registerRequest.getLastName() );
        user.setEmail( registerRequest.getEmail() );
        user.setDate( registerRequest.getDate() );
        user.setAddress( registerRequest.getAddress() );
        user.setPhoneNumber( registerRequest.getPhoneNumber() );

        return user;
    }
}
