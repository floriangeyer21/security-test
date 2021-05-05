package com.hibernate.testing.service.interfaces;

import com.hibernate.testing.domain.Course;
import com.hibernate.testing.domain.User;
import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getLazy();

    User getByName(String firstName);

    User getById(Long id);

    User addCharacteristicToUser(List<Course> courses, User user);
}
