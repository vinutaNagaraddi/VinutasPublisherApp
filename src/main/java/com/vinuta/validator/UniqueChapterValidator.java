package main.java.com.vinuta.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.vinuta.entity.Chapter;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class UniqueChapterValidator extends FieldValidatorSupport{

	@Override
	public void validate(Object object) throws ValidationException {
		// TODO Auto-generated method stub
		String fieldName = this.getFieldName();
		List<Chapter> chapters = (List<Chapter>) getFieldValue(fieldName, object); 
		
		List<Chapter> chaptersCopy  = new ArrayList<Chapter>();
		chaptersCopy.addAll(chapters);
		
		Iterator<Chapter> chaptersIterator = chapters.iterator();
		while(chaptersIterator.hasNext()){
			Chapter chapter = chaptersIterator.next();
			chaptersCopy.remove(chapter);
			
			//check if there is another article with the same values in the list
			if (chaptersCopy.contains(chapter)){
				this.addFieldError(fieldName,object);
				return;
			}
		}
	}

}
