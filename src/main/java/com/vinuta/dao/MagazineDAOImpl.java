package main.java.com.vinuta.dao;

import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Magazine;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class MagazineDAOImpl extends PublisherAppDAO implements MagazineDAO{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void addMagazine(Magazine magazine){
		// TODO Auto-generated method stub
		resetAuthorsListForAritlces(magazine);
		this.save(magazine);
	}

	@Override
	public void updateMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		resetAuthorsListForAritlces(magazine);
		this.merge(magazine);
	}

	@Override
	public void deleteMagazine(Long id) {
		// TODO Auto-generated method stub
		this.delete(getMagazineById(id));
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Magazine> listMagazines() {
		// TODO Auto-generated method stub
		Query magazineQuery = this.createQuery(" from Magazine mag" +
				" order by mag.name asc, mag.publishDate asc");
		return magazineQuery.list();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Magazine getMagazine(Long id) {
		// TODO Auto-generated method stub
		return getMagazineById(id);
	}
	
	private Magazine getMagazineById(Long id) {
		Magazine magazine = (Magazine) this.get(Magazine.class, id);
		return magazine;
	}

	//reset Authors List for articles with new and existing authors
	private void resetAuthorsListForAritlces(Magazine magazine){
		//loop through all articles for the magazine
		Iterator<Article> articlesIterator = magazine.getArticles().iterator();
		while(articlesIterator.hasNext()){
			Article article= articlesIterator.next();
			//reset the authors for the article
			article.setAuthors(this.getAuthorsListWithNewAndExistingAuthors(article.getAuthors()));
		}
	}
	
}
