package org.justjsf.proxibanque.service;

import java.util.List;

import org.justjsf.proxibanque.model.Customer;

public interface IService {

	void persist(Customer customer) throws Exception;

	void merge(Customer customer) throws Exception;

	Customer findById(Long idCustomer) throws Exception;

	void remove(Long idCustomer) throws Exception;

	List<Customer> findAll() throws Exception;

	List<Customer> getAudit() throws Exception;

	List<Customer> getWealthy() throws Exception;

}