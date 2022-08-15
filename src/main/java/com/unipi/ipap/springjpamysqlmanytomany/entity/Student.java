package com.unipi.ipap.springjpamysqlmanytomany.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENT_TBL")
// We use @Setter and @Getter instead of @Data, because @Data causes stackoverflow bug
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // Creates additional join table (id in STUDENT_TBL will be student_id in STUDENT_COURSE_TBL)
    @JoinTable(name = "STUDENT_COURSE_TBL", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")
    },
    // course_id will be the id of COURSE_TBL table
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    })
    // @JsonManagedReference // Unless it does stackoverflow Students -> Courses -> Students -> Courses...
    // or use @JsonIdentityInfo
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Set<Course> courses;
}
