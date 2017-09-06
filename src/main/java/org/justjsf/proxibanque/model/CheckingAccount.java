package org.justjsf.proxibanque.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CheckingAccount extends Account {
	
	private static final long serialVersionUID = -6892734998134813639L;
	private Double overdraft = -1000D;
	@OneToOne(mappedBy="checkingAccount")
	private Customer customer;
	public CheckingAccount() {
	}
	public Double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
