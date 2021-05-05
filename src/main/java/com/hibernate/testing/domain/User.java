package com.hibernate.testing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "users_courses",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id")},
            foreignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "fk_users"),
            inverseForeignKey = @ForeignKey(value = ConstraintMode.PROVIDER_DEFAULT, name = "fk_courses")
    )
    private List<Course> courses;
}
