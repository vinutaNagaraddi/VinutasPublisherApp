package main.java.com.vinuta.action;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Author;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.service.MagazineService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionSupport;

public class MagazineAction extends ActionSupport{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MagazineService magazineServiceImpl;
	
	public MagazineService getMagazineServiceImpl() {
		return magazineServiceImpl;
	}

	public void setMagazineServiceImpl(MagazineService magazineServiceImpl) {
		this.magazineServiceImpl = magazineServiceImpl;
	}

	public String addMagazine(){
		Author author1 = new Author("firstName1", "lastName1");
		Author author2 = new Author("firstName2", "lastName2");
		Author author3 = new Author("firstName3", "lastName3");
		
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(author1);
		authors1.add(author2);
		
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(author3);
		
		Set<Article> articles = new HashSet<Article>();
		Article article1 = new Article("title1", 10, authors1);
		Article article2 = new Article("title2", 20, authors2);
		Article article3 = new Article("title3", 20, authors2);
		
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
		
		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 14);
		
		Magazine magazine = new Magazine("magazineName1", 11.99,new Boolean(true), c.getTime(), articles);
		article1.setMagazine(magazine);
		article2.setMagazine(magazine);
		article3.setMagazine(magazine);
		
		this.magazineServiceImpl.addMagazine(magazine);
		
		return SUCCESS;
	}
	
	public String updateMagazine(){
		Author author1 = new Author("fn1", "ln1");
		Author author2 = new Author("firstName2", "lastName2");
		Author author3 = new Author("firstName3", "lastName3");
		
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(author1);
		authors1.add(author2);
		
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(author3);
		
		Article article1 = new Article("title1", 10, authors1);
		Article article2 = new Article("articletitle2", 20, authors2);
		
		Set<Article> articles = new HashSet<Article>();
		articles.add(article1);
		articles.add(article1);
		
		Calendar c = Calendar.getInstance();
		c.set(2009, 11, 14);
		
		Magazine magazine = new Magazine("magazineName1", 11.99, 
					new Boolean(true), c.getTime(), articles);
		article1.setMagazine(magazine);
		article2.setMagazine(magazine);
		
		this.magazineServiceImpl.updateMagazine(magazine);
		
		return SUCCESS;
	}
	
	public String deleteMagazine(){
		this.magazineServiceImpl.deleteMagazine(new Long(1));
		return SUCCESS;
	}
	
	public String listMagazines(){
		List<Magazine> magazines = this.magazineServiceImpl.listMagazines();
		for (Magazine m : magazines){
			logger.debug(m.toString());
		}
		return SUCCESS;
	}
}
