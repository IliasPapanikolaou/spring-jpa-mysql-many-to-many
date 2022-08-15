package com.unipi.ipap.springjpamysqlmanytomany.dto;

import com.unipi.ipap.springjpamysqlmanytomany.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseDto {

    private Long id;
    private String title;
    private String abbreviation;
    private Integer modules;
    private Double fee;
    private Set<Student> students;

}
