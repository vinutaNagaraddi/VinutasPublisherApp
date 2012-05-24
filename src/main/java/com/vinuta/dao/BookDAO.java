package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Book;



public interface BookDAO {
	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(Long id);
	List<Book> listBooks();
}
