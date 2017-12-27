package com.pervacio.adminportal.tradein.service;

import java.util.List;

import com.pervacio.adminportal.tradein.entities.Grade;


public interface GradeManager
{
	public List<Grade> getAll();
	public void add(Grade grade)  throws Exception;
	public  void remove(Grade grade)  throws Exception;
	public void update(Grade grade)  throws Exception;

}
