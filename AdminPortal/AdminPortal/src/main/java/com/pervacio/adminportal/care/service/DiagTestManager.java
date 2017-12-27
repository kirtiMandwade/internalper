package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.DiagTest;


public interface DiagTestManager
{
	public List<DiagTest> getAll();
	public void add(DiagTest diagTest) throws Exception;
	public  void remove(DiagTest diagTest) throws Exception;
	public void update(DiagTest diagTest) throws Exception ;
	public ArrayList<DiagTest> findByTestCd(String testCd) throws Exception;

}