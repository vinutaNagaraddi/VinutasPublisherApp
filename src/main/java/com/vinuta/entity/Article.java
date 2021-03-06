package main.java.com.vinuta.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name="ARTICLE", schema ="PUBLISHERAPP",
	uniqueConstraints= @UniqueConstraint(columnNames={"title", "magazine_id"})
)
public class Article implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@ManyToOne
	@JoinColumn(name="magazine_id", nullable=false)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@LazyCollection(LazyCollectionOption.FALSE) 
	private Magazine magazine;
	
	@Column(nullable=false)
	private String title;
	
	@Column(name="no_of_pages")
	private Integer noOfPages;
	
	@ManyToMany
	@JoinTable(name = "ARTICLE_AUTHOR", schema = "PUBLISHERAPP", joinColumns = { @JoinColumn(name = "article_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "author_id") }) 
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@LazyCollection(LazyCollectionOption.FALSE) 
	private List<Author> authors;
	
	public Article(){};
	
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
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
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
		if (title == null || title.isEmpty()) {
			if (other.title != null || !other.title.isEmpty())
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
