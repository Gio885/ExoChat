package it.exolab.exochat.crud;

import javax.persistence.EntityManager;

public abstract class BaseCrud <T> {

	public abstract T findById(Integer id,EntityManager entityManager) throws Exception;
	
	public abstract T insert(T oggetto,EntityManager entityManager) throws Exception;
	
	public abstract T update(T oggetto,EntityManager entityManager) throws Exception;
	
	public abstract boolean delete(T oggetto,EntityManager entityManager) throws Exception;
	
	
}
