package com.hibernate.testing.repository.test;

import com.hibernate.testing.domain.test.facebook.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole getUserRoleByRoleName(UserRole.RoleName roleName);
}
