package main.java.com.vinuta.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("COMICBOOK")
public class ComicBook extends Book{
	
	public ComicBook(){};
	
	@Column(name="no_of_pages")
	private Integer noOfPages;
	
	@Column(name="file_Name")
	private String fileName;
	
	@Column(name="cover_image_file")
	private byte[] coverImageFile;

	
	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getCoverImageFile() {
		return coverImageFile;
	}

	public void setCoverImageFile(byte[] coverImageFile) {
		this.coverImageFile = coverImageFile;
	}

	@Override
	public String toString() {
		return "ComicBook [noOfPages=" + noOfPages + ", fileName=" + fileName
				+ "]";
	}

}
