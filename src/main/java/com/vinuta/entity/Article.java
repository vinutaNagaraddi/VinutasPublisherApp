package main.java.com.vinuta.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="ARTICLE", schema ="PUBLISHERAPP")
public class Article implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@ManyToOne
	@JoinColumn(name="magazine_id", nullable=false)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	private Magazine magazine;
	
	@Column(nullable=false , unique=true)
	private String title;
	
	@Column(name="no_of_pages")
	private Integer noOfPages;
	
	@ManyToMany
	@JoinTable(name = "ARTICLE_AUTHOR", schema = "PUBLISHERAPP", joinColumns = { @JoinColumn(name = "article_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "author_id") }) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	private Set<Author> authors;
	
	public Article(){};
	
	public Article(String title, Integer noOfPages,
			Set<Author> authors) {
		super();
		this.title = title;
		this.noOfPages = noOfPages;
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

	public Magazine getMagazine() {
		return magazine;
	}
	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", version=" + version + "," +
				", title=" + title + ", noOfPages=" + noOfPages
				+ ", authors=" + authors + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
