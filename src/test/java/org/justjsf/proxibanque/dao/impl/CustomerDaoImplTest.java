package org.justjsf.proxibanque.dao.impl;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.justjsf.proxibanque.dao.ICustomerDao;
import org.justjsf.proxibanque.model.Advisor;
import org.justjsf.proxibanque.model.CheckingAccount;
import org.justjsf.proxibanque.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	ICustomerDao dao;

	@Test
	@Transactional
	public void testSaveCustomerWithNameAndFirstNameOnly() throws Exception {
		Customer customer = new Customer();
		customer.setName("Deglaire");
		customer.setFirstName("Jean");
		dao.persist(customer);
		assertEquals("Deglaire", dao.findById(customer.getId()).getName());
		assertEquals("Jean", dao.findById(customer.getId()).getFirstName());
	}
	
	@Test
	@Transactional
	public void testSaveCustomerWithAdvisor() throws Exception {
		Customer customer = new Customer();
		customer.setName("Deglaire");
		customer.setFirstName("Jean");
		Advisor advisor = new Advisor();
		advisor.setName("Destremau");
		advisor.setFirstName("François");
		customer.setAdvisor(advisor);
		dao.persist(customer);
		assertEquals("Destremau", dao.findById(customer.getId()).getAdvisor().getName());
	}
	
	@Test
	@Transactional
	public void testSaveCustomerWithAdvisorAndAccount() throws Exception {
		Customer customer = new Customer();
		customer.setName("Deglaire");
		customer.setFirstName("Jean");
		Advisor advisor = new Advisor();
		advisor.setName("Destremau");
		advisor.setFirstName("François");
		customer.setAdvisor(advisor);
		CheckingAccount account = new CheckingAccount();
		account.setDate(LocalDateTime.now());
		account.setBalance(2500D);
		customer.setCheckingAccount(account);
		dao.persist(customer);
		assertEquals("François", dao.findById(customer.getId()).getAdvisor().getFirstName());
		logger.log(Level.ERROR, dao.findById(customer.getId()).getCheckingAccount().getDate());
		assertEquals((Double)2500D, (Double)dao.findById(customer.getId()).getCheckingAccount().getBalance());
	}

	@Test
	@Transactional
	public void testUpdateCustomerWithAdvisorAndAccount() throws Exception {
		Customer customer = new Customer();
		customer.setName("Deglaire");
		customer.setFirstName("Jean");
		Advisor advisor = new Advisor();
		advisor.setName("Destremau");
		advisor.setFirstName("François");
		customer.setAdvisor(advisor);
		CheckingAccount account = new CheckingAccount();
		account.setDate(LocalDateTime.now());
		account.setBalance(2500D);
		customer.setCheckingAccount(account);
		dao.persist(customer);
		Customer customer2 = dao.findById(customer.getId());
		customer2.setFirstName("Thomas");
		dao.merge(customer2);
		assertEquals("Deglaire", dao.findById(customer.getId()).getName());
		assertEquals("Thomas", dao.findById(customer.getId()).getFirstName());
	}
	
	@Test
	@Transactional
	public void testDeleteCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setName("Deglaire");
		customer.setFirstName("Jean");
		dao.persist(customer);
		Customer customer2 = dao.findById(customer.getId());
		dao.remove(customer2.getId());
		assertNull(dao.findById(customer.getId()));
	}
}
