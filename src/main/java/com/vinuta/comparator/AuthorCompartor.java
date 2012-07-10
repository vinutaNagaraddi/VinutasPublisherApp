package main.java.com.vinuta.comparator;

import java.util.Comparator;

import main.java.com.vinuta.entity.Author;

public class AuthorCompartor implements Comparator<Author> {

	@Override
	public int compare(Author author1, Author author2) {
		// TODO Auto-generated method stub
		if (author1.getLastName().equals(author2.getLastName())){
			if(author1.getFirstName().compareTo(author2.getFirstName()) < 1){
				return 1;
			}
			else{
				return -1;
			}
		}
		else if(author1.getLastName().compareTo(author2.getLastName()) < 1){
			return 1;
		}
		else{
			return -1;
		}
	}
}
