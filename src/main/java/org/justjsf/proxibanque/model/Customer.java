package org.justjsf.proxibanque.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * Cette classe est responsable de la mod�lisation des clients. En plus des attributs h�rit�s de la classe Person, 
 * elle ajoute des attributs propres aux clients (adresse, code postal, ville et t�l�phone).
 * 
 * La classe permet de faire un lien entre un conseiller (advisor) et un client, ainsi qu'entre un client et ses comptes
 * bancaires (checkingAccount et savingAccount).
 * 
 * @author JustJSF
 *
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({ @NamedQuery(name = "customers.findAll", query = "select o from Customer o"), })
public class Customer extends Person {

	private static final long serialVersionUID = 7078730324493569314L;

	private String address;
	private String zipCode;
	private String city;
	private String phone;
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "ADVISOR_ID", referencedColumnName = "id")
	private Advisor advisor;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CHECKING_ACCOUNT_ID", referencedColumnName = "id")
	private CheckingAccount checkingAccount;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "SAVING_ACCOUNT_ID", referencedColumnName = "id")
	private SavingAccount savingAccount;

	public Customer() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
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

	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

}
