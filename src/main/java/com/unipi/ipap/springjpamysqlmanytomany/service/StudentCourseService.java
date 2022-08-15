package com.unipi.ipap.springjpamysqlmanytomany.service;

import com.unipi.ipap.springjpamysqlmanytomany.dto.CourseDto;
import com.unipi.ipap.springjpamysqlmanytomany.dto.StudentDto;
import com.unipi.ipap.springjpamysqlmanytomany.repository.CourseRepository;
import com.unipi.ipap.springjpamysqlmanytomany.repository.StudentRepository;
import com.unipi.ipap.springjpamysqlmanytomany.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Constructor
    public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentDto> findAllStudents() {
        return studentRepository.findAll().stream().map(Mapper::toDto).toList();
    }

    public Optional<StudentDto> findStudentById(Long id) {
        return studentRepository.findById(id).map(Mapper::toDto);
    }

    public List<StudentDto> findStudentByNameContaining(String name) {
        return studentRepository.findByNameContaining(name).stream().map(Mapper::toDto).toList();
    }

    public List<CourseDto> findCourseByFeeLessThan(double fee) {
        return courseRepository.findByFeeLessThan(fee).stream().map(Mapper::toDto).toList();
    }

    public StudentDto saveStudentWithCourse(StudentDto studentDto) {
        return Mapper.toDto(studentRepository.save(Mapper.toEntity(studentDto)));
    }

}
