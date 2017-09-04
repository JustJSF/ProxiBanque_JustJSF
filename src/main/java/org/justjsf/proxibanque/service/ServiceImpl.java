package org.justjsf.proxibanque.service;

import java.util.List;

import org.justjsf.proxibanque.dao.ICustomerDao;
import org.justjsf.proxibanque.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {

	@Autowired
	ICustomerDao customerDao;

	@Override
	public void persist(Customer customer) throws Exception {
		customerDao.persist(customer);
	}
	

	@Override
	public void merge(Customer customer) throws Exception {
		customerDao.merge(customer);
	}

	@Override
	public Customer findById(Long idCustomer) throws Exception {
		return customerDao.findById(idCustomer);
	}

	@Override
	public void remove(Long idCustomer) throws Exception {
		customerDao.remove(idCustomer);
	}
	
	@Override
	public List<Customer> findAll() throws Exception{
		return customerDao.findAll();
	}

}