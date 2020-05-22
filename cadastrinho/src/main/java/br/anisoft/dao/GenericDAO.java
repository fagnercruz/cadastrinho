package br.anisoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.anisoft.hibernate.HibernateUtils;

public class GenericDAO<E> {
	
	
	public void salvar(E entity) {
		EntityManager manager = HibernateUtils.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		manager.persist(entity);
		transacao.commit();
		manager.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<E> listar(E entity){
		EntityManager manager = HibernateUtils.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		List<E> lista = manager.createQuery("from " + entity.getClass().getSimpleName() + " order by id asc").getResultList();
		transacao.commit();
		manager.close();
		return lista;
	}
	
	public E atualizar(E entity) {
		EntityManager manager = HibernateUtils.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		E retorno = manager.merge(entity);
		transacao.commit();
		manager.close();
		return retorno;
	}
	
	public void excluir(E entity) {
		EntityManager manager = HibernateUtils.getEntityManager();
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		manager.remove(entity);
		transacao.commit();
		manager.close();
	}
	
	public void excluirPorID(E entity) {
		EntityManager manager = HibernateUtils.getEntityManager();
		Object pk =  HibernateUtils.getPK(entity);
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		manager.createQuery("delete from " + entity.getClass().getSimpleName() + " where id=" + pk).executeUpdate();
		transacao.commit();
		manager.close();
	}
	
}
