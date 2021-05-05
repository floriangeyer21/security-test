package com.hibernate.testing.service.impl.test.facebook.impl;

import com.hibernate.testing.domain.test.facebook.UserRole;
import com.hibernate.testing.repository.test.UserRoleRepository;
import com.hibernate.testing.service.impl.test.facebook.intefraces.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole add(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getRoleByName(String roleName) {
        return userRoleRepository.getUserRoleByRoleName(UserRole.RoleName.valueOf(roleName));
    }
}
