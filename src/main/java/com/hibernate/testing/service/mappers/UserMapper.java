package com.hibernate.testing.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.hibernate.testing.domain.User;
import com.hibernate.testing.domain.dto.UserRequestDto;
import com.hibernate.testing.domain.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courses", ignore = true)
    User mapUserRequestDtoToUser(UserRequestDto userRequestDto);

    UserResponseDto mapUserToUserResponseDto(User user);

   /* private final CourseMapper courseMapper;

    @Autowired
    public UserMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public User mapRequestDtoToUser(UserRequestDto userRequestDto) {
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .build();
    }

    public UserResponseDto mapUserToResponseDto(User user) {
        List<CourseResponseDto> courses = new ArrayList<>();
        if (user.getCourses() != null) {
            for (Course course : user.getCourses()) {
                courses.add(courseMapper.mapCharacteristicToResponseDto(course));
            }
        }
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .courses(courses)
                .build();
    }*/
}
