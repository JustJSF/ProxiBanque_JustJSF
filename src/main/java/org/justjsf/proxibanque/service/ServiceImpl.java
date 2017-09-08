package org.justjsf.proxibanque.service;

import java.util.ArrayList;
import java.util.List;

import org.justjsf.proxibanque.dao.ICustomerDao;
import org.justjsf.proxibanque.model.Account;
import org.justjsf.proxibanque.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cette classe est responsable de la modélisation du service de l'application pour tout ce qui a trait aux fonctionnalités proposé au Gérant.
 * 
 * @author adminl
 *
 */
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
	public List<Customer> findAll() throws Exception {
		return customerDao.findAll();
	}

	@Override
	public List<Customer> getAudit() throws Exception {
		List<Customer> customers = customerDao.findAll();
		List<Customer> audit = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getCheckingAccount().getBalance() < -5000
					|| customer.getSavingAccount().getBalance() < -5000) {
				audit.add(customer);
			}
		}
		return audit;

	}

	@Override
	public List<Customer> getWealthy() throws Exception {
		List<Customer> customers = customerDao.findAll();
		List<Customer> wealthy = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.getCheckingAccount().getBalance() > 50000
					|| customer.getSavingAccount().getBalance() > 50000) {
				wealthy.add(customer);
			}
		}
		return wealthy;
	}

	@Override
	public boolean transfer(Account debitAccount, Account creditAccount, double transferAmount) {
		if (debitAccount.getBalance() - transferAmount < -1000 || transferAmount < 0) {
			return false;
		} else {
			debitAccount.setBalance(debitAccount.getBalance() - transferAmount);
			creditAccount.setBalance(creditAccount.getBalance() + transferAmount);
			return true;
		}
	}
}
