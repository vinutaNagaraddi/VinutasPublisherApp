package main.java.com.vinuta.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Chapter;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Novel;
import main.java.com.vinuta.service.BookService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;



@Scope("prototype")
@SuppressWarnings("serial")
public class BookAction extends PublisherAppAction{

	private Logger logger = Logger.getLogger(this.getClass());
	
	public static Integer NO_OF_AUTHORS = 3;
	public static Integer NO_OF_CHAPTERS = 3;
	private List<ComicBook> comicBooks;
	private List<Novel> novels;
	private ComicBook comicBook;
	private Novel novel;
	
	@Autowired
	private BookService bookServiceImpl;
	
	
	public BookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	public ComicBook getComicBook() {
		return comicBook;
	}

	public void setComicBook(ComicBook comicBook) {
		this.comicBook = comicBook;
	}

	public Novel getNovel() {
		return novel;
	}

	public void setNovel(Novel novel) {
		this.novel = novel;
	}

	public List<ComicBook> getComicBooks() {
		return comicBooks;
	}

	public void setComicBooks(List<ComicBook> comicBooks) {
		this.comicBooks = comicBooks;
	}

	public List<Novel> getNovels() {
		return novels;
	}

	public void setNovels(List<Novel> novels) {
		this.novels = novels;
	}

	public String addComicBook(){
		comicBook.setAuthors(this.getNonEmptyAuthorsList(comicBook.getAuthors()));
		this.bookServiceImpl.addBook(comicBook);
		return SUCCESS;
	}
	
	public String updateComicBook(){
		comicBook.setAuthors(this.getNonEmptyAuthorsList(comicBook.getAuthors()));
		this.bookServiceImpl.updateBook(comicBook);
		return SUCCESS;
	}
	
	public String getComicBookById(){
		this.comicBook = (ComicBook) this.bookServiceImpl.getBook(comicBook.getId());
		return SUCCESS;
	}
	
	public String deleteComicBook(){
		this.bookServiceImpl.deleteBook(comicBook.getId());
		return SUCCESS;
	}
	
	public String addNovel(){
		novel.setAuthors(this.getNonEmptyAuthorsList(novel.getAuthors()));
		novel.setChapters(this.getNonEmptyChaptersList(novel.getChapters()));
		this.bookServiceImpl.addBook(novel);
		return SUCCESS;
	}
	
	public String updateNovel(){
		novel.setAuthors(this.getNonEmptyAuthorsList(novel.getAuthors()));
		novel.setChapters(this.getNonEmptyChaptersList(novel.getChapters()));
		this.bookServiceImpl.updateBook(novel);
		return SUCCESS;
	}
	
	public String deleteNovel(){
		this.bookServiceImpl.deleteBook(novel.getId());
		return SUCCESS;
	}
	
	public String getNovelById(){
		this.novel = (Novel) this.bookServiceImpl.getBook(novel.getId());
		return SUCCESS;
	}
	
	public String listBooks(){
		this.comicBooks = this.bookServiceImpl.listComicBooks();
		this.novels = this.bookServiceImpl.listNovels();
		return SUCCESS;
	}
	
	private List<Chapter> getNonEmptyChaptersList(List<Chapter> allChapters) {
		// TODO Auto-generated method stub
		List<Chapter> chapters = new ArrayList<Chapter>();
		
		//iterator through empty and non-empty chapters
		Iterator<Chapter> chaptersIterator = allChapters.iterator();
		while(chaptersIterator.hasNext()){
			Chapter chapter= chaptersIterator.next();
			
			if(chapter.getTitle().isEmpty()){
				continue;
			}
			
			chapter.setNovel(this.novel);
			
			//add the chapter with non-empty values to the new list
			chapters.add(chapter);
		}
		return chapters;
	}
}
