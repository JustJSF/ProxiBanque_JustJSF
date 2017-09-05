package org.justjsf.proxibanque.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Cette classe abstraite est responsable de la modélisation d'une personne
 * définie par son Id, son nom et son prénom.
 * 
 * @author JustJSF
 *
 */

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable{


	private static final long serialVersionUID = -5581603563785832729L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String name;
	private String firstName;

	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
