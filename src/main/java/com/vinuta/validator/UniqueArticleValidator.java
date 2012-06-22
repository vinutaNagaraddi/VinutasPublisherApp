package main.java.com.vinuta.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import main.java.com.vinuta.entity.Article;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class UniqueArticleValidator extends FieldValidatorSupport {

	@SuppressWarnings("unchecked")
	@Override
	public void validate(Object object) throws ValidationException {
		// TODO Auto-generated method stub
		String fieldName = this.getFieldName();
		List<Article> articles = (List<Article>) getFieldValue(fieldName, object); 
		
		List<Article> articlesCopy  = new ArrayList<Article>();
		Boolean listCopied = articlesCopy.addAll(articles);
		
		Iterator<Article> articlesIterator = articlesCopy.iterator();
		while(articlesIterator.hasNext()){
			Article article = articlesIterator.next();
			String articleTitle = article.getTitle();
			if(!articleTitle.isEmpty()){
				articlesCopy.remove(article);
				if (articlesCopy.contains(article)){
					this.addFieldError(fieldName,object);
					return;
				}
			}
		}
	}
}

