package com.hibernate.testing.service.impl;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.domain.User;
import com.hibernate.testing.repository.UserRepository;
import com.hibernate.testing.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CourseServiceImpl courseService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CourseServiceImpl courseService) {
        this.userRepository = userRepository;
        this.courseService = courseService;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getLazy() {
        return userRepository.findAll();
    }

    @Override
    public User getByName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User addCharacteristicToUser(List<Course> courses, User user) {
        user.setCourses(courses);
        return userRepository.save(user);
    }
}
