package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Novel;



public interface BookDAO {
	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(Long id);
	List<Book> listBooks();
	Book getBook(Long bookId);
	List<ComicBook> listComicBooks();
	List<Novel> listNovels();
}
