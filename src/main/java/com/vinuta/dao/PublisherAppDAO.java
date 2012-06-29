package main.java.com.vinuta.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Author;

import org.hibernate.Query;

public class PublisherAppDAO extends HibernateDAO{
	
protected List<Author> getAuthorsListWithNewAndExistingAuthors(List<Author> authors){
		
		Iterator<Author> authorsIterator = authors.iterator();
		List<Author> newAuthors = new ArrayList<Author>();
		
		//loop through all authors 
		while(authorsIterator.hasNext()){
			Author author= authorsIterator.next();
			
			//get existing author
			Author persistentAuthor = this.getAuthorByName(author.getLastName(), author.getFirstName());
			
			//add existing author to the list if it exists
			if (persistentAuthor == null){
				//associate the new author with the session so that another new author object 
				//with the same info can use this author object
				this.persist(author);
				newAuthors.add(author);
			}else{
				newAuthors.add(persistentAuthor);
			}
		}
		return newAuthors;
	}
	
	//find an existing author using firstname and lastname
	protected Author getAuthorByName(String lastName, String firstName){
		Query authorQuery = this.currentSession().createQuery("from Author where lastName=:lastName and firstName=:firstName");
		authorQuery.setString("lastName", lastName);
		authorQuery.setString("firstName", firstName);
		return (Author) authorQuery.uniqueResult();
	}
}
