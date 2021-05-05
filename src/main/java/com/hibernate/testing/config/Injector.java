package com.hibernate.testing.config;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.domain.User;
import com.hibernate.testing.domain.test.Post;
import com.hibernate.testing.service.impl.test.TestService;
import com.hibernate.testing.service.interfaces.CourseService;
import com.hibernate.testing.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Injector {
    private final UserService userService;
    private final CourseService courseService;
    private final TestService testService;

    @Autowired
    public Injector(UserService userService,
                    CourseService courseService,
                    TestService testService) {
        this.userService = userService;
        this.courseService = courseService;
        this.testService = testService;
    }

    @PostConstruct
    public void injectDataToDb() {
        injectUsersToDb();
        injectCoursesToDb();
        Post post = testService.getPst();
    }

    public void injectUsersToDb() {
        User user = User.builder()
                .firstName("Alice")
                .lastName("Bobson")
                .build();
        userService.save(user);
        user = User.builder()
                .firstName("Bop")
                .lastName("Alison")
                .build();
        userService.save(user);
    }

    public void injectCoursesToDb() {
        Course course = Course.builder()
                .description("Math")
                .build();
        courseService.save(course);
        course = Course.builder()
                .description("Programming")
                .build();
        courseService.save(course);
        course = Course.builder()
                .description("Physics")
                .build();
        courseService.save(course);
    }
}
