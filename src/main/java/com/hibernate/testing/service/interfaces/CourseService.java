package com.hibernate.testing.service.interfaces;

import com.hibernate.testing.domain.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<Course> getAll();

    Course getById(Long id);

    Course getByName(String name);
}
