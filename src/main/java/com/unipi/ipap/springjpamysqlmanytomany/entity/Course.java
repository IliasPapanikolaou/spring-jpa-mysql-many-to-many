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
@Table(name = "COURSE_TBL")
// We use @Setter and @Getter instead of @Data, because @Data causes stackoverflow bug
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String abbreviation;
    private Integer modules;
    private Double fee;
    // mappedBy tells to JPA that this is the secondary entity by passing the name of the Set<Course> courses
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    // @JsonBackReference // Unless it does stackoverflow Students -> Courses -> Students -> Courses...
    // or use @JsonIdentityInfo
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Set<Student> students;
}
