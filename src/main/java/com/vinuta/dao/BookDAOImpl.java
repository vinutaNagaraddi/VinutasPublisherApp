package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.entity.Novel;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRED)
public class BookDAOImpl extends PublisherAppDAO implements BookDAO{

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		book.setAuthors(this.getAuthorsListWithNewAndExistingAuthors(book.getAuthors()));
		this.save(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		book.setAuthors(this.getAuthorsListWithNewAndExistingAuthors(book.getAuthors()));
		this.merge(book);
	}

	public void updateComicBook(ComicBook comicBook){
		ComicBook persistedComicBook = (ComicBook) this.getBookById(comicBook.getId());
		if (comicBook.getUpdatedAttachmentArray() != null){
			comicBook.setAttachmentArray(comicBook.getUpdatedAttachmentArray());
			comicBook.setAttachmentContentType(comicBook.getUpdatedAttachmentContentType());
			comicBook.setAttachmentFileName(comicBook.getUpdatedAttachmentFileName());
		}else{
			comicBook.setAttachmentArray(persistedComicBook.getAttachmentArray());
			comicBook.setAttachmentContentType(persistedComicBook.getAttachmentContentType());
			comicBook.setAttachmentFileName(persistedComicBook.getAttachmentFileName());
		}
		comicBook.setAuthors(this.getAuthorsListWithNewAndExistingAuthors(comicBook.getAuthors()));
		this.merge(comicBook);
	}
	
	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		Book book = (Book) this.currentSession().get(Book.class, id);
		this.delete(book);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		return getBookById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<ComicBook> listComicBooks() {
		// TODO Auto-generated method stub
		Query bookQuery = this.currentSession().createQuery("from ComicBook cb" +
				" order by cb.name asc");
		return  bookQuery.list();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Novel> listNovels() {
		// TODO Auto-generated method stub
		Query bookQuery = this.currentSession().createQuery("from Novel n" +
				" order by n.name asc");
		return bookQuery.list();
	}
	
	private Book getBookById(Long id) {
		return (Book) this.currentSession().get(Book.class, id);
	}
	
}
