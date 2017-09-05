package org.justjsf.proxibanque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "ADVISOR")
@NamedQueries({ @NamedQuery(name = "advisors.findAll", query = "select o from Advisor o"), })
@PrimaryKeyJoinColumn(name="id")
public class Advisor extends Person {

	private static final long serialVersionUID = -2672470972167529913L;

	private String login;
	private String password;
	@OneToMany(mappedBy = "advisor")
	private Set<Customer> customers = new HashSet<>();

	public Advisor() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
