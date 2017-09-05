package org.justjsf.proxibanque.service;

import java.util.List;

import org.justjsf.proxibanque.model.Advisor;

public interface IAdvisorService {

	void persist(Advisor advisor) throws Exception;

	void merge(Advisor advisor) throws Exception;

	Advisor findById(Long idAdvisor) throws Exception;

	void remove(Long idAdvisor) throws Exception;

	List<Advisor> findAll() throws Exception;

}