package com.pervacio.adminportal.care.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pervacio.adminportal.care.entities.EUser;

public interface EUserRepository extends JpaRepository<EUser, Integer> {
	/*public long countByUserIdAndPassword(String userId, String password);*/
	@Query(nativeQuery=true,value="Select * from euser where userid=:userId and password=SHA2(:password,256)")
	public ArrayList<EUser> findUserByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);
	public EUser findByUserId(String userId);


}
