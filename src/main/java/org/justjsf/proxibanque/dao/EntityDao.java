package org.justjsf.proxibanque.dao;

import java.util.List;

/**
 * Interface définissant les méthodes qui seront utilisées.
 * 
 * @author JustJSF
 *
 */

public interface EntityDao<E> {
	
	/**
	 * @param e : ajoute l'e à la BDD
	 * @throws Exception à la création de session
	 */
	void persist(E e) throws Exception;
	
	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;
	
	E findById(Object id) throws Exception;
	
	List<E> findAll() throws Exception;
	
	List<E> findByProperty(String prop, Object val) throws Exception;
	
	List<E> findInRange(int firstResult, int maxResults) throws Exception;
	
	long count() throws Exception;
	
	
}
