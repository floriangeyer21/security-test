package com.hibernate.testing.security;

import com.hibernate.testing.domain.test.facebook.Customer;
import com.hibernate.testing.domain.test.facebook.UserRole;
import com.hibernate.testing.service.impl.test.facebook.intefraces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private CustomerService customerService;

    @Autowired
    public MyUserDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Invalid email " + email);
        }
        User.UserBuilder builder = org.springframework.security.core.userdetails
                .User.withUsername(email);
        builder.password(customer.getPassword());
        String[] roles = customer.getRoles().stream()
                .map(role -> role.getRoleName().toString())
                .toArray(String[]::new);
        builder.roles(roles);
        return builder.build();
    }
}
