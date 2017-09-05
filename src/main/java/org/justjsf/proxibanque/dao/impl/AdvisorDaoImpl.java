package org.justjsf.proxibanque.dao.impl;


import org.justjsf.proxibanque.dao.IAdvisorDao;
import org.justjsf.proxibanque.model.Advisor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AdvisorDaoImpl extends EntityDaoImpl<Advisor> implements IAdvisorDao {

}
