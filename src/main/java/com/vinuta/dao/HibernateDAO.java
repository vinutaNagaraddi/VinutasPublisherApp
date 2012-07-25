package main.java.com.vinuta.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	protected void save(Object obj){
		currentSession().save(obj);
	}
	
	protected void merge(Object obj){
		currentSession().merge(obj);
	}
	
	protected void persist(Object obj){
		currentSession().persist(obj);
	}
	
	protected void delete(Object obj){
		currentSession().delete(obj);
	}
	
	protected Query createQuery(String sql){
		return currentSession().createQuery(sql);
	}
	
	protected Criteria createCritera(Class obj){
		return currentSession().createCriteria(obj);
	}
	
	protected Object get(Class obj, Long id){
		return currentSession().get(obj, id);
	}
}
