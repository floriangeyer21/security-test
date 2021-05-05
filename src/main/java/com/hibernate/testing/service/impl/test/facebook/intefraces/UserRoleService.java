package com.hibernate.testing.service.impl.test.facebook.intefraces;

import com.hibernate.testing.domain.test.facebook.UserRole;

public interface UserRoleService {

    UserRole add(UserRole userRole);

    UserRole getRoleByName(String roleName);
}
