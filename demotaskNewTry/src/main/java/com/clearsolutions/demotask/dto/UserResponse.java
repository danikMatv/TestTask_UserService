package com.clearsolutions.demotask.dto;

import lombok.Builder;

@Builder
public record UserResponse(String firstName, String lastName,
                           String email, int date, String address,String phoneNumber)
{
}
