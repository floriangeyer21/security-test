package com.hibernate.testing.security;

import com.hibernate.testing.domain.test.facebook.Customer;
import com.hibernate.testing.domain.test.facebook.UserRole;
import com.hibernate.testing.service.impl.test.facebook.intefraces.CustomerService;
import com.hibernate.testing.service.impl.test.facebook.intefraces.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final CustomerService customerService;;
    private final UserRoleService roleService;

    public AuthenticationServiceImpl(CustomerService customerService,
                                     UserRoleService roleService) {
        this.customerService = customerService;
        this.roleService = roleService;
    }

    @Override
    public Customer register(String email, String password) {
        Customer customer = Customer.builder()
                .email(email)
                .password(password)
                .build();
        Set<UserRole> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("USER"));
        customer.setRoles(roles);
        customer = customerService.add(customer);
        return customer;
    }
}
