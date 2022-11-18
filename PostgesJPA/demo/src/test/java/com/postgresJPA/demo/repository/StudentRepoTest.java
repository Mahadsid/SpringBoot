package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Guardian;
import com.postgresJPA.demo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {
    @Autowired
    private  StudentRepo studentRepo;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("mahad@gmail.com")
                .firstname("mahad")
                .lastname("siddiqui")
                //.guardianName("Msid")
                //.guardianEmail("Msid@gmail.com")
                //.guardianMobile("123456")
                .build();

        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuardianClass(){

        Guardian guardian = Guardian.builder()
                .name("HighTable")
                .email("Hightable@gmail.com")
                .mobile("666")
                .build();

        Student student = Student.builder()
                .firstname("Jhon")
                .lastname("Wick")
                .emailId("Babayag@gmail.com")
                .guardian(guardian)
                .build();

        studentRepo.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepo.findAll();
        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepo.findByFirstname("mahad");
        System.out.println("StudentByFirstName = " + students);
        //Mockito.when(studentRepo.findByName("mahad")).thenReturn(students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students =
                studentRepo.findByFirstnameContaining("Jh");
        System.out.println("Student = " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students =
                studentRepo.findByGuardianName("Msid");
        System.out.println("Student = " + students);
    }

    //JPQL
    @Test
    public void  getStudentByEmailAddress(){
       Student student = studentRepo.getStudentByEmailAddress("Babayag@gmail.com");
        System.out.println("StudentByEmail = " + student);
    }

    //JPQL
    @Test
    public void printgetStudentFirstnameByEmailAddress(){
        String firstName = studentRepo.getStudentFirstnameByEmailAddress("Babayag@gmail.com");
        System.out.println("StudentFirstNameByEmail = " + firstName);
    }

    //NativeQuery
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepo.getStudentByEmailAddressNative("mahad@gmail.com");
        System.out.println("StudentByEmailNative = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepo.getStudentByEmailAddressNativeNamedParam("mahad@gmail.com");
        System.out.println("StudentByEmailNative = " + student);
    }

    @Test
    public void printupdateStudentNameByEmailId(){
        studentRepo.updateStudentNameByEmailId("Muhammad", "sid@gmail.com");

    }



}