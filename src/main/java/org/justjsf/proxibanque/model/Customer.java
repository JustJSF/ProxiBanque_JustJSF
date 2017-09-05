package org.justjsf.proxibanque.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="customer")
@NamedQueries({ @NamedQuery(name = "customers.findAll", query = "select o from Customer o"), })
public class Customer extends Person implements Serializable{

	private static final long serialVersionUID = 7078730324493569314L;

	public Customer() {
	}

}
