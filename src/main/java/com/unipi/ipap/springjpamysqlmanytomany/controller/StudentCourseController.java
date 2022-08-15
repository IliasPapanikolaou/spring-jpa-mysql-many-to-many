package com.unipi.ipap.springjpamysqlmanytomany.controller;

import com.unipi.ipap.springjpamysqlmanytomany.dto.CourseDto;
import com.unipi.ipap.springjpamysqlmanytomany.dto.StudentDto;
import com.unipi.ipap.springjpamysqlmanytomany.service.StudentCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    private final StudentCourseService service;

    public StudentCourseController(StudentCourseService service) {
        this.service = service;
    }

    @GetMapping("/student")
    public List<StudentDto> findAllStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.of(service.findStudentById(id));
    }

    @GetMapping("/student/name/{name}")
    public List<StudentDto> getStudentsContainingByName(@PathVariable String name) {
        return service.findStudentByNameContaining(name);
    }

    @GetMapping("/course/{price}")
    public List<CourseDto> findCourseLessThanPrice(@PathVariable double price) {
        return service.findCourseByFeeLessThan(price);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok().body(service.saveStudentWithCourse(studentDto));
    }
}
