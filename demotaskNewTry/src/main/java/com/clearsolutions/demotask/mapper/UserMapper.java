package com.clearsolutions.demotask.mapper;

import com.clearsolutions.demotask.domain.User;
import com.clearsolutions.demotask.dto.RegisterRequest;
import com.clearsolutions.demotask.dto.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User updateUser(@MappingTarget User user, UpdateUserRequest updateUserRequest);

    User map(RegisterRequest registerRequest);

}
