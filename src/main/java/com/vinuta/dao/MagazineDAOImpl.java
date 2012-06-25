package main.java.com.vinuta.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Author;
import main.java.com.vinuta.entity.Magazine;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class MagazineDAOImpl extends HibernateDAO implements MagazineDAO{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void addMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		resetAuthorsListForAritlces(magazine);
		this.saveOrUpdate(magazine);
	}

	@Override
	public void updateMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		resetAuthorsListForAritlces(magazine);
		this.saveOrUpdate(magazine);
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
		Query magazineQuery = this.currentSession().createQuery("from Magazine");
		return magazineQuery.list();
	}

	@Override
	public Magazine getMagazine(Long id) {
		// TODO Auto-generated method stub
		return getMagazineById(id);
	}
	
	private Magazine getMagazineById(Long id) {
		Magazine magazine = (Magazine) this.currentSession().get(Magazine.class, id);
		return magazine;
	}

	//reset Authors List for articles with new and existing authors
	private void resetAuthorsListForAritlces(Magazine magazine){
		//loop through all articles for the magazine
		Iterator<Article> articlesIterator = magazine.getArticles().iterator();
		while(articlesIterator.hasNext()){
			Article article= articlesIterator.next();
			//reset the authors for the article
			article.setAuthors(getAuthorsListWithNewAndExistingAuthors(article.getAuthors()));
		}
	}
	
	private List<Author> getAuthorsListWithNewAndExistingAuthors(List<Author> authors){
		
		Iterator<Author> authorsIterator = authors.iterator();
		List<Author> newAuthors = new ArrayList<Author>();
		
		//loop through all authors for the article
		while(authorsIterator.hasNext()){
			Author author= authorsIterator.next();
			
			//get existing author
			Author persistentAuthor = this.getAuthorByName(author.getLastName(), author.getFirstName());
			
			//add existing author to the list if it exists
			if (persistentAuthor == null){
				newAuthors.add(author);
			}else{
				newAuthors.add(persistentAuthor);
			}
		}
		return newAuthors;
	}
	
	//find an existing author using firstname and lastname
	private Author getAuthorByName(String lastName, String firstName){
		Query authorQuery = this.currentSession().createQuery("from Author where lastName=:lastName and firstName=:firstName");
		authorQuery.setString("lastName", lastName);
		authorQuery.setString("firstName", firstName);
		return (Author) authorQuery.uniqueResult();
	}
}
