package main.java.com.vinuta.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;

import main.java.com.vinuta.entity.Author;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@SuppressWarnings("serial")
public class PublisherAppAction  extends ActionSupport{
	
	private static Map<String,String> symbols = new HashMap<String,String>();
	public static String LESSTHANEQUAL = "Less Than or Equal";
	public static String GREATERTHANEQUAL = "Greater Than or Equal";
	public static String TRUE = "True";
	public static String FALSE= "False";
	private static Map<String, String> booleanValues = new HashMap<String, String>();
	
	static{
		symbols.put(LESSTHANEQUAL, LESSTHANEQUAL);
		symbols.put(GREATERTHANEQUAL, GREATERTHANEQUAL);
		
		booleanValues.put(TRUE, TRUE);
		booleanValues.put(FALSE, FALSE);
	}
	
	
	public Map<String, String> getSymbols() {
		return symbols;
	}

	public Map<String, String> getBooleanValues() {
		return booleanValues;
	}

	//get list of authors with non-empty values
	protected List<Author> getNonEmptyAuthorsList(List<Author> allAuthors){
		List<Author> authors = new ArrayList<Author>();
		
		//iterator through empty and non-empty authors
		Iterator<Author> authorsIterator = allAuthors.iterator();
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
