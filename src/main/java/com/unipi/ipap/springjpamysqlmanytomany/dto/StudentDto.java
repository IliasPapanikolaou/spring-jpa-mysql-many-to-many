package com.unipi.ipap.springjpamysqlmanytomany.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDto {

    private Long id;
    private String name;
    private int age;
    private String dept;
//    @JsonManagedReference // Unless it does stackoverflow Students -> Courses -> Students -> Courses...
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id")
    private Set<CourseDto> courses;

}
