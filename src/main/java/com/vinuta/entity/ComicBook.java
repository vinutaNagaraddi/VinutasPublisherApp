package main.java.com.vinuta.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COMICBOOK")
public class ComicBook extends Book{
	
	public ComicBook(){};
	
	public ComicBook(String name, Double price, Date publishDate,
			List<Author> authors, byte[] coverImageFile, String fileName) {
		super(name, price, publishDate, authors);
		this.coverImageFile = coverImageFile;
		this.fileName = fileName;
	}

	@Column(name="file_Name")
	private String fileName;
	
	@Column(name="cover_image_file")
	private byte[] coverImageFile;

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
		return "ComicBook [fileName=" + fileName + ", toString()="
				+ super.toString() + "]";
	}
}
