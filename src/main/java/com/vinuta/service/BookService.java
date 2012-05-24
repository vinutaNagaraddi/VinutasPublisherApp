package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.Magazine;


public interface BookService {
	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(Long id);
	List<Book> listBooks();
}
