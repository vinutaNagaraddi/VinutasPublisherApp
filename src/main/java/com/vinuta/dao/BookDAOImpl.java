package main.java.com.vinuta.dao;

import java.util.Date;
import java.util.List;

import main.java.com.vinuta.action.PublisherAppAction;
import main.java.com.vinuta.dto.ComicBookDTO;
import main.java.com.vinuta.dto.NovelDTO;
import main.java.com.vinuta.entity.Book;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Novel;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		Book book = (Book) this.get(Book.class, id);
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
		Query bookQuery = this.createQuery("from ComicBook cb" +
				" order by cb.name asc");
		return  bookQuery.list();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Novel> listNovels() {
		// TODO Auto-generated method stub
		Query bookQuery = this.createQuery("from Novel n" +
				" order by n.name asc");
		return bookQuery.list();
	}
	
	private Book getBookById(Long id) {
		return (Book) this.get(Book.class, id);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Novel> searchNovels(NovelDTO novelDTO) {
		// TODO Auto-generated method stub
		Criteria novelCriteria = this.createCritera(Novel.class);
		
		if (novelDTO != null && novelDTO.getNovel() != null){
			Novel novel = novelDTO.getNovel();
			
			if (novel.getAuthors() != null && novel.getAuthors().get(0) != null){
				String firstName = novel.getAuthors().get(0).getFirstName();
				String lastName = novel.getAuthors().get(0).getLastName();
				
				Criteria authorCriteria = null;
				if(firstName!= null && !firstName.isEmpty()){
					authorCriteria = novelCriteria.createCriteria("authors");
					authorCriteria.add(Restrictions.like("firstName", firstName, MatchMode.ANYWHERE));
				}
				if(lastName != null && !lastName.isEmpty()){
					if(authorCriteria == null){
						authorCriteria = novelCriteria.createCriteria("authors");
					}
					authorCriteria.add(Restrictions.like("lastName", lastName, MatchMode.ANYWHERE));
				}
			}
			
			String name = novel.getName();
			if(name != null && !name.isEmpty()){
				novelCriteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
			}
			
			String isbn = novel.getIsbn();
			if(isbn != null  && !isbn.isEmpty()){
				novelCriteria.add(Restrictions.like("isbn", isbn, MatchMode.ANYWHERE));
			}
			
			Double price = novel.getPrice();
			if(price != null){
				if (novelDTO.getPriceSymbol().equals(PublisherAppAction.GREATERTHANEQUAL)){
					novelCriteria.add(Restrictions.ge("price", price));
				}else{
					novelCriteria.add(Restrictions.le("price", price));
				}
			}
			
			Date publishDate = novel.getPublishDate();
			if(publishDate != null){
				if (novelDTO.getPublishDateSymbol().equals(PublisherAppAction.GREATERTHANEQUAL)){
					novelCriteria.add(Restrictions.ge("publishDate", publishDate));
				}else{
					novelCriteria.add(Restrictions.le("publishDate", publishDate));
				}
			}
		}
		novelCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		novelCriteria.addOrder(Order.asc("name"));
		List<Novel> novels =  novelCriteria.list();
		
		return novels;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<ComicBook> searchComicBooks(ComicBookDTO comicBookDTO) {
		// TODO Auto-generated method stub
		Criteria comicBookCriteria = this.createCritera(ComicBook.class);
		
		if (comicBookDTO != null && comicBookDTO.getComicBook() != null){
			ComicBook comicBook = comicBookDTO.getComicBook();
			
			if (comicBook.getAuthors() != null && comicBook.getAuthors().get(0) != null){
				String firstName = comicBook.getAuthors().get(0).getFirstName();
				String lastName = comicBook.getAuthors().get(0).getLastName();
				
				Criteria authorCriteria = null;
				if(firstName!= null && !firstName.isEmpty()){
					authorCriteria = comicBookCriteria.createCriteria("authors");
					authorCriteria.add(Restrictions.like("firstName", firstName, MatchMode.ANYWHERE));
				}
				if(lastName != null && !lastName.isEmpty()){
					if(authorCriteria == null){
						authorCriteria = comicBookCriteria.createCriteria("authors");
					}
					authorCriteria.add(Restrictions.like("lastName", lastName, MatchMode.ANYWHERE));
				}
			}
			
			String name = comicBook.getName();
			if(name != null && !name.isEmpty()){
				comicBookCriteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
			}
			
			
			Double price = comicBook.getPrice();
			if(price != null){
				if (comicBookDTO.getPriceSymbol().equals(PublisherAppAction.GREATERTHANEQUAL)){
					comicBookCriteria.add(Restrictions.ge("price", price));
				}else{
					comicBookCriteria.add(Restrictions.le("price", price));
				}
			}
			
			Date publishDate = comicBook.getPublishDate();
			if(publishDate != null){
				if (comicBookDTO.getPublishDateSymbol().equals(PublisherAppAction.GREATERTHANEQUAL)){
					comicBookCriteria.add(Restrictions.ge("publishDate", publishDate));
				}else{
					comicBookCriteria.add(Restrictions.le("publishDate", publishDate));
				}
			}
		}
		comicBookCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		comicBookCriteria.addOrder(Order.asc("name"));
		List<ComicBook> comicBooks =  comicBookCriteria.list();
		
		return comicBooks;
	}
}
