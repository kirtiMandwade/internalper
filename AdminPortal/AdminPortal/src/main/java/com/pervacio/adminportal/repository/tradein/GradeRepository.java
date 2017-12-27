package com.pervacio.adminportal.repository.tradein;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.tradein.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, String> {

}
