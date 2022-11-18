package com.postgresJPA.demo.repository;

import com.postgresJPA.demo.Entity.Course;
import com.postgresJPA.demo.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Long> {
}
