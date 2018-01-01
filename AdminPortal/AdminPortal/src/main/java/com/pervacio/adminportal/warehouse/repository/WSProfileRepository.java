package com.pervacio.adminportal.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.WSProfile;
import com.pervacio.adminportal.warehouse.entities.WSProfileId;

public interface WSProfileRepository extends JpaRepository<WSProfile, WSProfileId>{

}
