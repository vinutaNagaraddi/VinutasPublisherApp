package main.java.com.vinuta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="CHAPTER", schema ="PUBLISHERAPP",
	uniqueConstraints=@UniqueConstraint(columnNames={"title", "novel_id"})
)
public class Chapter implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@Column(nullable=false)
	private String title;
	
	@Column(name="no_of_pages")
	private Integer noOfPages;
	
	@ManyToOne
	@JoinColumn(name="novel_id", nullable=false)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(value={CascadeType.SAVE_UPDATE})
	private Novel novel;
	
	public Chapter(){};
	
	
	public Chapter(String title, Integer noOfPages) {
		super();
		this.title = title;
		this.noOfPages = noOfPages;
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
	public Novel getNovel() {
		return novel;
	}
	public void setNovel(Novel novel) {
		this.novel = novel;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", version=" + version + ", title="
				+ title + ", noOfPages=" + noOfPages + "]";
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
		Chapter other = (Chapter) obj;
		if (title == null || title.isEmpty()) {
			if (other.title != null || !other.title.isEmpty())
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
