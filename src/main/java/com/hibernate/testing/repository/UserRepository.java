package com.hibernate.testing.repository;

import com.hibernate.testing.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = ("courses"))
    public User findByFirstName(String firstName);
}
