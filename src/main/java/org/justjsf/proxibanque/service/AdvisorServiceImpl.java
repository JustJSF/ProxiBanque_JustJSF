package org.justjsf.proxibanque.service;

import java.util.List;

import org.justjsf.proxibanque.dao.IAdvisorDao;
import org.justjsf.proxibanque.model.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvisorServiceImpl implements IAdvisorService {

	@Autowired
	IAdvisorDao advisorDao;

	@Override
	public void persist(Advisor advisor) throws Exception {
		advisorDao.persist(advisor);
	}
	

	@Override
	public void merge(Advisor advisor) throws Exception {
		advisorDao.merge(advisor);
	}

	@Override
	public Advisor findById(Long idAdvisor) throws Exception {
		return advisorDao.findById(idAdvisor);
	}

	@Override
	public void remove(Long idAdvisor) throws Exception {
		advisorDao.remove(idAdvisor);
	}
	
	@Override
	public List<Advisor> findAll() throws Exception{
		return advisorDao.findAll();
	}

}