package com.pervacio.adminportal.tradein.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.tradein.entities.Grade;
import com.pervacio.adminportal.tradein.repository.GradeRepository;

@Repository
@Transactional
public class GradeDao
{
	@Autowired
	private GradeRepository gradeRepository;


	public List<Grade> getAll() {
		// TODO Auto-generated method stub
		return gradeRepository.findAll();
	}


	public void add(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeRepository.saveAndFlush(grade);
	}


	public void remove(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeRepository.delete(grade);
	}


	public void update(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeRepository.saveAndFlush(grade);
	}


	/*@PersistenceContext
	private EntityManager manager;

	public List<Grade> getAllGrades() {
		List<Grade> gradeEntities = manager.createQuery("Select a From Grade a", Grade.class).getResultList();
		return gradeEntities;
	}

	public void add(Grade Grade)  throws Exception {
		manager.persist(Grade);

	}

	public void remove(String gradeCode) throws Exception {
		Grade d= manager.find(Grade.class, gradeCode);
	         manager.remove(d);

	}

	public void update(Grade Grade)  throws Exception {
		manager.merge(Grade);

	}
*/
}