package com.pervacio.adminportal.care.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.AppConfig;
import com.pervacio.adminportal.care.entities.DiagIssuesFlow;
import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.Promotion;

public interface DiagTestCompanyMapRepository extends JpaRepository<DiagTestCompanyMap, Integer>{
public ArrayList<DiagTestCompanyMap> findAllByCompanyCompanyName(String companyName);
}
