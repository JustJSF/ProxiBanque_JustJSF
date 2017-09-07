package org.justjsf.proxibanque.dao;

import java.util.List;

/**
 * Interface g�n�rique d�finissant les m�thodes de persistance pour tous les objets.
 * 
 *
 */

public interface EntityDao<E> {
	
	/**
	 * @param e : ajoute e � la BDD
	 * @throws Exception � la cr�ation de session
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
