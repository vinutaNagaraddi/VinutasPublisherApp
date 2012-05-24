package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.dao.BookDAO;
import main.java.com.vinuta.dao.MagazineDAO;
import main.java.com.vinuta.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;


public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDAOImpl;
	
	
	public BookDAO getBookDAOImpl() {
		return bookDAOImpl;
	}

	public void setBookDAOImpl(BookDAO bookDAOImpl) {
		this.bookDAOImpl = bookDAOImpl;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.bookDAOImpl.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		this.bookDAOImpl.updateBook(book);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		this.bookDAOImpl.deleteBook(id);
	}

	@Override
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return this.bookDAOImpl.listBooks();
	}
}
