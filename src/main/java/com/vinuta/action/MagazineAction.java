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
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class MagazineAction extends ActionSupport implements ModelDriven{
	@Autowired
	private MagazineService magazineServiceImpl;
	
	private Logger logger = Logger.getLogger(this.getClass());
	private List<Magazine> magazines;
	private Magazine magazine;
	public static Integer NO_OF_ARTICLES = 3;
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
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return new Magazine();
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	public String addMagazine(){
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

}
