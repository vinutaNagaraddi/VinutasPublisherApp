package main.java.com.vinuta.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.vinuta.entity.Author;
import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.Chapter;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.entity.Novel;
import main.java.com.vinuta.service.BookService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private BookService bookServiceImpl;
	
	
	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	public String addBook(){
		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 14);
		
		Author author1 = new Author("firstName4", "lastName4");
		Author author2 = new Author("firstName5", "lastName5");
		Author author3 = new Author("firstName6", "lastName6");
		
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(author1);
		authors1.add(author2);
		
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(author3);
		
		Set<Chapter> chapters = new HashSet<Chapter>();
		Chapter c1 = new Chapter("chapter1", 10);
		Chapter c2 = new Chapter("chapter2", 20);
		Chapter c3 = new Chapter("chapter3", 30);
		chapters.add(c1);
		chapters.add(c2);
		chapters.add(c3);
		
		Novel novel = new Novel("Novel1", new Double(12.99), c.getTime(), authors1, 
				"1111111", chapters);
		c1.setNovel(novel);
		c2.setNovel(novel);
		c3.setNovel(novel);
		
		this.bookServiceImpl.addBook(novel);
		
		ComicBook comicBook = new ComicBook("ComicBook1", new Double(15.00),c.getTime(),
				authors2, null, "comicBookImage name1");
		
		this.bookServiceImpl.addBook(comicBook);
		
		return SUCCESS;
	}
	
	public String updateBook(){
		this.bookServiceImpl.updateBook(null);
		return SUCCESS;
	}
	
	public String deleteBook(){
		this.bookServiceImpl.deleteBook(new Long(1));
		return SUCCESS;
	}
	
	public String listBooks(){
		List<Book> books = this.bookServiceImpl.listBooks();
		for (Book book : books){
			logger.debug(book.toString());
		}
		return SUCCESS;
	}
}
