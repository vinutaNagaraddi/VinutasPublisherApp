package main.java.com.vinuta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="BOOK_TYPE", discriminatorType=DiscriminatorType.STRING)
@Table(name="BOOK", schema ="PUBLISHERAPP")
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@Column(nullable=false)
	private String name;
	
	private Double price;
	
	@Column(name="publish_date")
	private Date publishDate;
	
	@ManyToMany
	@JoinTable(name = "BOOK_AUTHOR", schema = "PUBLISHERAPP", joinColumns = { @JoinColumn(name = "book_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "author_id") }) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	Set<Author> authors = new HashSet<Author>();
	
	public Book(){};
	
	public Book(String name, Double price, Date publishDate, Set<Author> authors) {
		super();
		this.name = name;
		this.price = price;
		this.publishDate = publishDate;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", version=" + version + ", name=" + name
				+ ", price=" + price + ", publishDate=" + publishDate
				+ ", author=" + authors + "]";
	}
}
