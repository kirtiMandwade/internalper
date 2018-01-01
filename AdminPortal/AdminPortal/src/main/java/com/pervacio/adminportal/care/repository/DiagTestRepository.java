package com.pervacio.adminportal.care.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.pervacio.adminportal.care.entities.DiagTest;

public interface DiagTestRepository extends JpaRepository<DiagTest, String>{

	public ArrayList<DiagTest> findByTestCd( String testCd);

}
