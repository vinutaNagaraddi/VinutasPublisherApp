package main.java.com.vinuta.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Article;
import main.java.com.vinuta.entity.Author;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class UniqueAuthorPerArticleValidator extends FieldValidatorSupport {

	@Override
	public void validate(Object object) throws ValidationException {
		// TODO Auto-generated method stub
		
		String fieldName = this.getFieldName();
		List<Author> authors = (List<Author>) getFieldValue(fieldName, object); 
		
		List<Author> authorsCopy  = new ArrayList<Author>();
		authorsCopy.addAll(authors);
		
		Iterator<Author> authorsIterator = authors.iterator();
		while(authorsIterator.hasNext()){
			Author author = authorsIterator.next();
			authorsCopy.remove(author);
			
			//check if there is another author with the same values for this article
			if (authorsCopy.contains(author)){
				this.addFieldError(fieldName,object);
				return;
			}
		}
	}

}
