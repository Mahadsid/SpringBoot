package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Course;
import com.postgresJPA.demo.Entity.Teacher;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher(){
        Course courseJPA = Course.builder()
                .title("JPA")
                .credit(4)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(2)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Failure")
                        .lastName("SetBack")
                        //.course(List.of(courseJPA,courseJAVA))
                        .build();
        teacherRepo.save(teacher);
    }
}