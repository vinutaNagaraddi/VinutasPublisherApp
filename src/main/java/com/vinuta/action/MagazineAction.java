package main.java.com.vinuta.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.dto.MagazineDTO;
import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Magazine;
import main.java.com.vinuta.service.MagazineService;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;


@Scope("prototype")
public class MagazineAction extends PublisherAppAction{
	private static final long serialVersionUID = 856347245739524297L;

	@Autowired
	private MagazineService magazineServiceImpl;
	
	private Logger logger = Logger.getLogger(this.getClass());
	private List<Magazine> magazines;
	private Magazine magazine;
	private MagazineDTO magazineDTO;
	public static Integer NO_OF_ARTICLES = 5;
	public static Integer NO_OF_AUTHORS = 3;
	
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
	
	public MagazineDTO getMagazineDTO() {
		return magazineDTO;
	}

	public void setMagazineDTO(MagazineDTO magazineDTO) {
		this.magazineDTO = magazineDTO;
	}

	public String execute(){
		return SUCCESS;
	}
	
	public String addMagazine(){
		magazine.setArticles(getNonEmptyArticles(magazine.getArticles()));
		try{
			this.magazineServiceImpl.addMagazine(magazine);
		}
		catch(ConstraintViolationException ue){
			this.addActionError(this.getText("unique.magazine.exception"));
			return INPUT;
		}
		return SUCCESS;
	}

	public String getMagazineById(){
		this.magazine = this.magazineServiceImpl.getMagazine(magazine.getId());
		return SUCCESS;
	}
	
	public String updateMagazine(){
		magazine.setArticles(getNonEmptyArticles(magazine.getArticles()));
		try{
			this.magazineServiceImpl.updateMagazine(magazine);
		}
		catch(DataIntegrityViolationException ue){
			this.addActionError(this.getText("unique.magazine.exception"));
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String deleteMagazine(){
		this.magazineServiceImpl.deleteMagazine(this.magazine.getId());
		return SUCCESS;
	}
	
	public String searchMagazines(){
		this.magazines = this.magazineServiceImpl.seachMagazines(magazineDTO);
		return SUCCESS;
	}
	
	public String listMagazines(){
		this.magazines = this.magazineServiceImpl.listMagazines();
		return SUCCESS;
	}
	
	//get list of articles with non-empty values
	private List<Article> getNonEmptyArticles(List<Article> allArticles) {
		List<Article> articles = new ArrayList<Article>();
		
		//iterator through empty and non-empty articles
		Iterator<Article> articlesIterator = allArticles.iterator();
		while(articlesIterator.hasNext()){
			Article article= articlesIterator.next();
			
			if(article.getTitle().isEmpty()){
				continue;
			}
			
			//reset list with non-empty authors
			article.setAuthors(getNonEmptyAuthorsList(article.getAuthors()));
			article.setMagazine(magazine);
			
			//add the article with non-empty values to the new list
			articles.add(article);
		}
		return articles;
	}
	
}
