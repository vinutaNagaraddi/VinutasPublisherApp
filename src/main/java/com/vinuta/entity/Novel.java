package main.java.com.vinuta.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@DiscriminatorValue("NOVEL")
public class Novel extends Book{

	public Novel(){};
	
	public Novel(String name, Double price, Date publishDate, List<Author> author, 
				String isbn, List<Chapter> chapters) {
		super(name, price, publishDate, author);
		this.isbn = isbn;
		this.chapters = chapters;
	}

	private String isbn;
	
	@OneToMany(mappedBy="novel", orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.ALL})
	private List<Chapter> chapters;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Novel [" + super.toString() + " isbn=" + isbn + ", chapters=" + chapters + "]";
	}

	
}