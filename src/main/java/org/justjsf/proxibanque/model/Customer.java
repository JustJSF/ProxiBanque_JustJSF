package org.justjsf.proxibanque.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table (name="CUSTOMER")
@NamedQueries({ @NamedQuery(name = "customers.findAll", query = "select o from Customer o"), })
public class Customer extends Person {

	private static final long serialVersionUID = 7078730324493569314L;
	

	private String adress;
	private String zipCode;
	private String city;
	private String phone;
	@ManyToOne
	@JoinColumn(name= "ADVISOR_ID", referencedColumnName = "id")
	private Advisor advisor;

	public Customer() {
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}


}
