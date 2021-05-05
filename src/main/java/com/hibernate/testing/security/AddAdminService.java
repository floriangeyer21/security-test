package com.hibernate.testing.security;

import com.hibernate.testing.domain.test.facebook.Customer;
import com.hibernate.testing.domain.test.facebook.UserRole;
import com.hibernate.testing.service.impl.test.facebook.intefraces.CustomerService;
import com.hibernate.testing.service.impl.test.facebook.intefraces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class AddAdminService {
    private static final String USER_ROLE_NAME = "USER";
    private static final String ADMIN_ROLE_NAME = "ADMIN";
    private final CustomerService customerService;
    private final UserRoleService userRoleService;

    @Autowired
    public AddAdminService(CustomerService customerService, UserRoleService userRoleService) {
        this.customerService = customerService;
        this.userRoleService = userRoleService;
    }

    @PostConstruct
    public void initData() {
        userRoleService.add(UserRole.of(USER_ROLE_NAME));
        userRoleService.add(UserRole.of(ADMIN_ROLE_NAME));
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRoleService.getRoleByName(ADMIN_ROLE_NAME));
        Customer admin = Customer.builder()
                .email("admin@gmail.com")
                .password("12345")
                .roles(roles)
                .build();
        customerService.add(admin);
    }
}
