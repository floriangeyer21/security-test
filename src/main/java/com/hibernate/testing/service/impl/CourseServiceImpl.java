package com.hibernate.testing.service.impl;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.repository.CourseRepository;
import com.hibernate.testing.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course){
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.getOne(id);
    }

    @Override
    public Course getByName(String name) {
        return courseRepository.findByDescription(name);
    }
}
