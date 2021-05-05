package com.hibernate.testing.service.mappers;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.domain.dto.CourseRequestDto;
import com.hibernate.testing.domain.dto.CourseResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "description", target = "description")
    Course mapRequestDtoToCharacteristic(CourseRequestDto courseRequestDto);

    CourseResponseDto mapCharacteristicToResponseDto(Course course);
}
