package com.hibernate.testing.service.impl.test;

import com.hibernate.testing.domain.test.Post;
import com.hibernate.testing.repository.test.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public Post getPst() {
        Post post = new Post();
        if (testRepository.findById(1L).isPresent()) {
            post = testRepository.findById(1L).get();
        }
        return post;
    }
}
