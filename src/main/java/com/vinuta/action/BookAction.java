package main.java.com.vinuta.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.com.vinuta.dto.ComicBookDTO;
import main.java.com.vinuta.dto.NovelDTO;
import main.java.com.vinuta.entity.Chapter;
import main.java.com.vinuta.entity.ComicBook;
import main.java.com.vinuta.entity.Novel;
import main.java.com.vinuta.service.BookService;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Result;



@Scope("prototype")
public class BookAction extends PublisherAppAction{

	private static final long serialVersionUID = -2322939872905264367L;

	private Logger logger = Logger.getLogger(this.getClass());
	
	public static Integer NO_OF_AUTHORS = 3;
	public static Integer NO_OF_CHAPTERS = 3;
	private List<ComicBook> comicBooks;
	private List<Novel> novels;
	private ComicBook comicBook;
	private Novel novel;
	private NovelDTO novelDTO;
	private ComicBookDTO comicBookDTO;
	
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
	
	public NovelDTO getNovelDTO() {
		return novelDTO;
	}

	public void setNovelDTO(NovelDTO novelDTO) {
		this.novelDTO = novelDTO;
	}

	public ComicBookDTO getComicBookDTO() {
		return comicBookDTO;
	}

	public void setComicBookDTO(ComicBookDTO comicBookDTO) {
		this.comicBookDTO = comicBookDTO;
	}

	public String addComicBook(){
		comicBook.setAuthors(this.getNonEmptyAuthorsList(comicBook.getAuthors()));
		comicBook.convertFileToByte();
		try{
			this.bookServiceImpl.addBook(comicBook);
		}
		catch(ConstraintViolationException ue){
			this.addActionError(this.getText("unique.comicBook.exception"));
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String updateComicBook(){
		comicBook.setAuthors(this.getNonEmptyAuthorsList(comicBook.getAuthors()));
		comicBook.convertUpdatedFileToByte();
		try{
			this.bookServiceImpl.updateComicBook(comicBook);
		}
		catch(DataIntegrityViolationException ue){
			this.addActionError(this.getText("unique.comicBook.exception"));
			return INPUT;
		}
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
	
	public String searchComicBooks(){
		this.comicBooks = this.bookServiceImpl.searchComicBooks(this.comicBookDTO);
		return SUCCESS;
	}
	
	public String addNovel(){
		novel.setAuthors(this.getNonEmptyAuthorsList(novel.getAuthors()));
		novel.setChapters(this.getNonEmptyChaptersList(novel.getChapters()));
		try{
			this.bookServiceImpl.addBook(novel);
		}
		catch(ConstraintViolationException ue){
			this.addActionError(this.getText("unique.novel.exception"));
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String updateNovel(){
		novel.setAuthors(this.getNonEmptyAuthorsList(novel.getAuthors()));
		novel.setChapters(this.getNonEmptyChaptersList(novel.getChapters()));
		try{
			this.bookServiceImpl.updateBook(novel);
		}
		catch(DataIntegrityViolationException ue){
			this.addActionError(this.getText("unique.novel.exception"));
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String deleteNovel(){
		this.bookServiceImpl.deleteBook(novel.getId());
		return SUCCESS;
	}
	
	public String searchNovels(){
		this.novels = this.bookServiceImpl.searchNovels(this.novelDTO);
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
	
	public InputStream getInputStream() {
		this.getComicBookById();
		try {
			Result result = (Result) ActionContext.getContext().getActionInvocation().getResult();
			if (result != null && result instanceof StreamResult){
				StreamResult streamResult = (StreamResult) result;
				streamResult.setContentType(comicBook.getAttachmentContentType());
			}
			
			return new ByteArrayInputStream(comicBook.getAttachmentArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.warn(e);
		}
		return null;
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
