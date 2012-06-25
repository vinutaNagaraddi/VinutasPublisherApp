package main.java.com.vinuta.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Author;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.service.MagazineService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@SuppressWarnings("serial")
public class MagazineAction extends ActionSupport{
	@Autowired
	private MagazineService magazineServiceImpl;
	
	private Logger logger = Logger.getLogger(this.getClass());
	private List<Magazine> magazines;
	private Magazine magazine;
	public static Integer NO_OF_ARTICLES = 5;
	public static Integer NO_OF_AUTHORS = 4;
	
	public MagazineService getMagazineServiceImpl() {
		return magazineServiceImpl;
	}

	public void setMagazineServiceImpl(MagazineService magazineServiceImpl) {
		this.magazineServiceImpl = magazineServiceImpl;
	}

	public List<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	public String addMagazine(){
		List<Article> articles = getNonEmptyArticles();
		magazine.setArticles(articles);
		this.magazineServiceImpl.addMagazine(magazine);
		return SUCCESS;
	}

	public String getMagazineById(){
		this.magazine = this.magazineServiceImpl.getMagazine(magazine.getId());
		return SUCCESS;
	}
	
	public String updateMagazine(){
		List<Article> articles = getNonEmptyArticles();
		magazine.setArticles(articles);
		this.magazineServiceImpl.updateMagazine(magazine);
		return SUCCESS;
	}
	
	public String detailsMagazine(){
		magazine = this.magazineServiceImpl.getMagazine(this.magazine.getId());
		return SUCCESS;
	}
	
	public String deleteMagazine(){
		this.magazineServiceImpl.deleteMagazine(this.magazine.getId());
		return SUCCESS;
	}
	
	public String listMagazines(){
		this.magazines = this.magazineServiceImpl.listMagazines();
		return SUCCESS;
	}
	
	//get list of articles with non-empty values
	private List<Article> getNonEmptyArticles() {
		List<Article> articles = new ArrayList<Article>();
		
		//iterator through empty and non-empty articles
		Iterator<Article> articlesIterator = magazine.getArticles().iterator();
		while(articlesIterator.hasNext()){
			Article article= articlesIterator.next();
			
			if(article.getTitle().isEmpty()){
				continue;
			}
			
			//reset list with non-empty authors
			article.setAuthors(getNonEmptyAuthorsList(article));
			article.setMagazine(magazine);
			
			//add the article with non-empty values to the new list
			articles.add(article);
		}
		return articles;
	}
	
	//get list of authors with non-empty values
	private List<Author> getNonEmptyAuthorsList(Article article){
		List<Author> authors = new ArrayList<Author>();
		
		//iterator through empty and non-empty authors
		Iterator<Author> authorsIterator = article.getAuthors().iterator();
		while(authorsIterator.hasNext()){
			Author author = authorsIterator.next();
			
			if(author.getLastName().isEmpty() && author.getFirstName().isEmpty()){
				continue;
			}
			
			//add the author with non-empty values to the new list
			authors.add(author);
		}
		
		return authors;
	}
	
}
