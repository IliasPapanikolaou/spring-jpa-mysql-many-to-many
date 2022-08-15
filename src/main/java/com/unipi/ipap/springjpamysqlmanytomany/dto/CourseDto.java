package com.unipi.ipap.springjpamysqlmanytomany.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference // Unless it does stackoverflow Students -> Courses -> Students -> Courses...
//    @JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
    private Set<StudentDto> students;

}
