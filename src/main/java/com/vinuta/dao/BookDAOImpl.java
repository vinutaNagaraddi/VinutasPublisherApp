package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Book;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRED)
public class BookDAOImpl extends HibernateDAO implements BookDAO{

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(book);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		Book book = (Book) this.currentSession().get(Book.class, id);
		this.delete(book);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		Query bookQuery = this.currentSession().createQuery("from Book");
		return bookQuery.list();
	}
}
