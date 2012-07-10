package main.java.com.vinuta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.persistence.CascadeType;

import org.hibernate.annotations.OrderBy;


@Entity
@Table(name="MAGAZINE", schema ="PUBLISHERAPP",
	uniqueConstraints= @UniqueConstraint(columnNames={"name", "publish_date"})
)
public class Magazine implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@Column(name="name", nullable=false)
	private String name;
	
	private Double price;
	
	@Column(name="av_online")
	private Boolean availableOnline;
	
	@Column(name="publish_date", nullable=false)
	private Date publishDate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, 
			mappedBy="magazine", orphanRemoval=true)
	@OrderBy(clause="title asc")
	private List<Article> articles;
	
	public Magazine(){};
	
	public Magazine(String name, Double price,Boolean availableOnline, Date publishDate, 
			List<Article> articles) {
		super();
		this.name = name;
		this.price = price;
		this.availableOnline = availableOnline;
		this.publishDate = publishDate;
		this.articles = articles;
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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Boolean getAvailableOnline() {
		return availableOnline;
	}
	public void setAvailableOnline(Boolean availableOnline) {
		this.availableOnline = availableOnline;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", version=" + version
				+ ", name=" + name + ", price=" + price
				+ ", availableOnline=" + availableOnline + ", publishDate="
				+ publishDate + ", articles=" + articles + "]";
	}

	
}
