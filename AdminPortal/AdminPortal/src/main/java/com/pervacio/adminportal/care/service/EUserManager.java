package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EUser;


public interface EUserManager
{
	public List<EUser> getAll();
	public void add(EUser euser) throws Exception;
	public  void remove(EUser eUser) throws Exception;
	public void update(EUser euser) throws Exception ;
	public Boolean getUserByUsernameAndPassword(String userid,String password) throws Exception;
	public EUser getUserByUsername(String userid) throws Exception;
	public ArrayList<EUser> findUserByCompanyName(String companyName);
}
