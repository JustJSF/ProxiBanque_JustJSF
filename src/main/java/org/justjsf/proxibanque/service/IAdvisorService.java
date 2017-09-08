package org.justjsf.proxibanque.service;

import java.util.List;

import org.justjsf.proxibanque.model.Advisor;

/**
 * Cette Interface résume les méthodes qui peuvent être utilisé par la couche Présentation pour les services fournis au Conseiller
 * 
 * @author JustJSF
 *
 */
public interface IAdvisorService {

	void persist(Advisor advisor) throws Exception;

	void merge(Advisor advisor) throws Exception;

	Advisor findById(Long idAdvisor) throws Exception;

	void remove(Long idAdvisor) throws Exception;

	List<Advisor> findAll() throws Exception;

	boolean isValid(String login, String password);

}