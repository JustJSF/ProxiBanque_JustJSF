package org.justjsf.proxibanque.dao.impl;

import org.justjsf.proxibanque.dao.ICustomerDao;
import org.justjsf.proxibanque.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CustomerDaoImpl extends EntityDaoImpl<Customer> implements ICustomerDao {

	
}
