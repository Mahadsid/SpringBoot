package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

      public List<Student> findByFirstname(String firstNNName);
      public List<Student> findByFirstnameContaining(String nname);

      public List<Student> findByGuardianName(String gname);

      @Query("Select s from Student s where s.emailId = ?1")
      Student getStudentByEmailAddress(String EmailID);

      @Query("Select s.firstname from Student s where s.emailId = ?1")
      String getStudentFirstnameByEmailAddress(String EmailID);

      @Query(
              value = "Select * from tbl_student s where s.email_address = ?1",
              nativeQuery = true
      )
      Student getStudentByEmailAddressNative(String EmailID);


      //native named param
      @Query(
              value = "Select * from tbl_student s where s.email_address = :emailId",
              nativeQuery = true
      )
      Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

      //Update
      @Modifying
      @Transactional
      @Query(
              value = "update tbl_student set firstname = ?1 where email_address = ?2",
              nativeQuery = true
      )
      int updateStudentNameByEmailId(String firstname, String emailId);












}
