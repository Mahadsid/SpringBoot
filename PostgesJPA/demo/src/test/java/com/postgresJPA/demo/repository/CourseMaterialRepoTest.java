package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Course;
import com.postgresJPA.demo.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void  SaveCourseMaterial(){

        Course course = Course.builder()
                .title("ML")
                .credit(6)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.WSchool.com")
                        .course(course)
                        .build();
        courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterialsLAZY(){
        List<CourseMaterial> courseMaterials = courseMaterialRepo.findAll();
        System.out.println("CourseMaterial = " + courseMaterials);
    }


}