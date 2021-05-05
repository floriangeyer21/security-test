package com.hibernate.testing.controllers;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.domain.User;
import com.hibernate.testing.domain.dto.UserRequestDto;
import com.hibernate.testing.domain.dto.UserResponseDto;
import com.hibernate.testing.service.interfaces.CourseService;
import com.hibernate.testing.service.interfaces.UserService;
import com.hibernate.testing.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final CourseService courseService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService,
                          CourseService courseService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.courseService = courseService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userMapper.mapUserToUserResponseDto(userService.save(
                userMapper.mapUserRequestDtoToUser(userRequestDto)));
    }

    @GetMapping("add-course")
    public UserResponseDto addCourseToUser(@RequestParam(name = "course") Long courseId, @RequestParam(name = "user") Long userId) {
        User user = userService.getById(userId);
        Course course = courseService.getById(courseId);
        if (user.getCourses() != null) {
            user.getCourses().add(course);
        }
        user = userService.save(user);
        return userMapper.mapUserToUserResponseDto(user);
    }

    @GetMapping("all")
    public List<UserResponseDto> getAllUsers() {
        return userService.getLazy().stream()
                .map(userMapper::mapUserToUserResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userMapper.mapUserToUserResponseDto(userService.getById(id));
    }

    @GetMapping
    public UserResponseDto getUserByName(@RequestParam String name) {
        return userMapper.mapUserToUserResponseDto(userService.getByName(name));
    }
}
