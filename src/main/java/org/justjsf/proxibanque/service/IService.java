package org.justjsf.proxibanque.service;

import java.util.List;
import org.justjsf.proxibanque.model.Account;
import org.justjsf.proxibanque.model.Customer;

/**
 * Cette Interface r�sume les m�thodes qui peuvent �tre utilis� par la couche Pr�sentation pour les services fournis au G�rant
 * 
 * @author JustJSF
 *
 */
public interface IService {

	void persist(Customer customer) throws Exception;

	void merge(Customer customer) throws Exception;

	Customer findById(Long idCustomer) throws Exception;

	void remove(Long idCustomer) throws Exception;

	List<Customer> findAll() throws Exception;

	List<Customer> getAudit() throws Exception;

	List<Customer> getWealthy() throws Exception;

	boolean transfer(Account debitAccount, Account creditAccount, double transferAmount);

}