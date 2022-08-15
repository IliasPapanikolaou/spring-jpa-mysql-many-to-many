package com.unipi.ipap.springjpamysqlmanytomany.dto;

import com.unipi.ipap.springjpamysqlmanytomany.entity.Course;
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
    private Set<Course> courses;

}
