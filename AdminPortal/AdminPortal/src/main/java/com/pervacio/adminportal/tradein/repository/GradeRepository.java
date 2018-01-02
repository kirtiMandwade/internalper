package com.pervacio.adminportal.tradein.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.tradein.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, String> {
	
	public List<Grade> findByGradeCode(String gradeCode);
	
}
