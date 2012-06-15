package main.java.com.vinuta.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Article;
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
	public static Integer NO_OF_ARTICLES = 2;
	public static Integer NO_OF_AUTHORS = 2;
	
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
		logger.debug(magazine.toString());
		List<Article> articleList = magazine.getArticles();
		Iterator<Article> i = articleList.iterator();
		while(i.hasNext()){
			Article article= i.next();
			article.setMagazine(magazine);
		}
		this.magazineServiceImpl.addMagazine(magazine);
		return SUCCESS;
	}
	
	public String updateMagazine(){
		this.magazineServiceImpl.updateMagazine(magazine);
		return SUCCESS;
	}
	
	public String deleteMagazine(){
		this.magazineServiceImpl.deleteMagazine(magazine.getId());
		return SUCCESS;
	}
	
	public String listMagazines(){
		this.magazines = this.magazineServiceImpl.listMagazines();
		return SUCCESS;
	}
	
	public void validateAddMagazine(){
		logger.debug(magazine.toString());
	}
}
