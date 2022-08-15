package com.unipi.ipap.springjpamysqlmanytomany.util;

import com.unipi.ipap.springjpamysqlmanytomany.dto.CourseDto;
import com.unipi.ipap.springjpamysqlmanytomany.dto.StudentDto;
import com.unipi.ipap.springjpamysqlmanytomany.entity.Course;
import com.unipi.ipap.springjpamysqlmanytomany.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static StudentDto toDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public static Student toEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    public static CourseDto toDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    public static Course toEntity(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }
}
