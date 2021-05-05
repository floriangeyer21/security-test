package com.hibernate.testing.controllers;

import com.hibernate.testing.domain.test.facebook.CustomerRequestDto;
import com.hibernate.testing.domain.test.facebook.CustomerResponseDto;
import com.hibernate.testing.security.AuthenticationService;
import com.hibernate.testing.service.impl.test.facebook.mappers.CustomerMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final CustomerMapper customerMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    CustomerMapper customerMapper) {
        this.authenticationService = authenticationService;
        this.customerMapper = customerMapper;
    }

    @PostMapping("/register")
    public CustomerResponseDto register(@RequestBody CustomerRequestDto customerRequestDto) {
        String email = customerRequestDto.getEmail();
        String password = customerRequestDto.getPassword();
        return customerMapper.mapCustomerToCustomerResponseDto(
                authenticationService.register(email, password));
    }
}
