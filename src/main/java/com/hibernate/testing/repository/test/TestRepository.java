package com.hibernate.testing.repository.test;

import com.hibernate.testing.domain.test.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Post, Long> {

    @EntityGraph(value = "post-entity-graph")
    Optional<Post> findById(Long id);
}
