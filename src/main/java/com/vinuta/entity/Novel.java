package main.java.com.vinuta.entity;

import java.util.Date;
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
	
	public Novel(String name, Double price, Date publishDate, Set<Author> author, 
				String isbn, Set<Chapter> chapters) {
		super(name, price, publishDate, author);
		this.isbn = isbn;
		this.chapters = chapters;
	}

	private String isbn;
	
	@OneToMany(mappedBy="novel", orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.ALL})
	private Set<Chapter> chapters;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Novel [isbn=" + isbn + ", chapters=" + chapters
				+ ", toString()=" + super.toString() + "]";
	}
	
}