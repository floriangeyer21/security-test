package com.hibernate.testing.security;


import com.hibernate.testing.domain.test.facebook.Customer;

public interface AuthenticationService {

    Customer register(String email, String password);
}