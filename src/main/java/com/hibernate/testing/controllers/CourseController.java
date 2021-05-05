package com.hibernate.testing.controllers;

import com.hibernate.testing.domain.dto.CourseRequestDto;
import com.hibernate.testing.domain.dto.CourseResponseDto;
import com.hibernate.testing.service.interfaces.CourseService;
import com.hibernate.testing.service.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService,
                            CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto characteristic) {
        return courseMapper.mapCharacteristicToResponseDto(courseService.save(courseMapper.mapRequestDtoToCharacteristic(characteristic)));
    }

    @GetMapping("{id}")
    public CourseResponseDto getCCourseById(@PathVariable Long id) {
        return courseMapper.mapCharacteristicToResponseDto(courseService.getById(id));
    }
}
