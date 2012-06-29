package main.java.com.vinuta.dao;

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

	protected Session currentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	protected void saveOrUpdate(Object obj){
		currentSession().saveOrUpdate(obj);
	}
	
	protected void persist(Object obj){
		currentSession().persist(obj);
	}
	
	protected void delete(Object obj){
		currentSession().delete(obj);
	}
	
}
