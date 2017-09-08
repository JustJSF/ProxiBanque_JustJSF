package org.justjsf.proxibanque.service;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.justjsf.proxibanque.dao.IAdvisorDao;
import org.justjsf.proxibanque.model.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Cette classe est responsable de la modélisation du service de l'application pour tout ce qui a trait aux fonctionnalités proposé au Conseiller.
 * 
 * @author JustJSF
 *
 */
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
	public List<Advisor> findAll() throws Exception {
		return advisorDao.findAll();
	}

	public boolean isValid(String login, String password) {
		String expectedPassword = null;

		try {
			List<Advisor> advisors = advisorDao.findByProperty("login", login);
			for (Advisor advisor : advisors) {
				expectedPassword = advisor.getPassword();
			}

		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Pas de mot de passe correspondant");
		}
		if (expectedPassword != null && expectedPassword.equalsIgnoreCase(password)
		)
			return true;
		else
			return false;
	}

}