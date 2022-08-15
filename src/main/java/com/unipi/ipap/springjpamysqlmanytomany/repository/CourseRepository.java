package com.unipi.ipap.springjpamysqlmanytomany.repository;

import com.unipi.ipap.springjpamysqlmanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(double fee);
}
