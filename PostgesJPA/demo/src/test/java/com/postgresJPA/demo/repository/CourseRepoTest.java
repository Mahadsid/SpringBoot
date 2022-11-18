package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Course;
import com.postgresJPA.demo.Entity.Student;
import com.postgresJPA.demo.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepo.findAll();
        System.out.println("Courses = "+courses);
    }


    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Andrew")
                .lastName("Tate")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }


    @Test
    public void findAllPagination(){
        PageRequest firstPagewithThreeRecords = PageRequest.of(0, 3);
        PageRequest secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepo.findAll(firstPagewithThreeRecords).getContent();

        long totElements =
                courseRepo.findAll(firstPagewithThreeRecords).getTotalElements();

        long totPages =
                courseRepo.findAll(firstPagewithThreeRecords).getTotalPages();

        System.out.println("totPages = "+totPages);
        System.out.println("totElements = "+totElements);
        System.out.println("courses = "+courses);

    }


    @Test
    public void findAllSorting(){
        PageRequest sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        PageRequest sortByCreditDesc =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        PageRequest sortByTitleAndCreditDesc =
                PageRequest.of(0, 2, Sort.by("title").descending().
                        and(Sort.by("credit")));

        List<Course> courses = courseRepo.findAll(sortByTitle).getContent();
        System.out.println("sortByTitle = "+courses);
    }

//    @Test
//    public void printfindByTitleContaining(){
//        PageRequest firstPageTenRecords =
//                PageRequest.of(0,10);
//        List<Course> courses =
//                courseRepo.findByTitleContaining(
//                        "J",
//                        firstPageTenRecords
//                ).getContent();
//        System.out.println("Courses = "+courses);
//    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Steezy")
                .lastName("Kane")
                .build();

        Student student = Student.builder()
                .firstname("Muhammad")
                .lastname("Mahad")
                .emailId("mahads@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepo.save(course);
    }

}