package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.entity.Novel;


public interface BookService {
	void addBook(Book book);
	void updateBook(Book book);
	void updateComicBook(ComicBook comicBook);
	void deleteBook(Long id);
	Book getBook(Long id);
	List<ComicBook> listComicBooks();
	List<Novel> listNovels();
}
