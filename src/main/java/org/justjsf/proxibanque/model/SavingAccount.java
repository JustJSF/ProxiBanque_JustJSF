package org.justjsf.proxibanque.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Cette classe est responsable de la modélisation des comptes épargnes.
 * 
 * @author JustJSF
 *
 */

@Entity
public class SavingAccount extends Account {

	private static final long serialVersionUID = -9098602297586507358L;
	private Double wageRate;
	@OneToOne(mappedBy="savingAccount")
	private Customer customer;
	public SavingAccount() {
	}
	public Double getWageRate() {
		return wageRate;
	}
	public void setWageRate(Double wageRate) {
		this.wageRate = wageRate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
