package main.java.com.vinuta.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.type.LobType;

@Entity
@DiscriminatorValue("COMICBOOK")
public class ComicBook extends Book{
	
	public ComicBook(){};
	
	@Column(name="no_of_pages")
	private Integer noOfPages;
	
	
	@Column(name="cover_image_file")
	@Lob
	private byte[] coverImageFile;

	@Transient
	private File attachment;
	
	@Column(name="cover_image_file_Name")
	private String attachmentFileName;
	
	@Transient
	private String attachmentContentType;
	
	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	public String getAttachmentContentType() {
		return attachmentContentType;
	}

	public void setAttachmentContentType(String attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public byte[] getCoverImageFile() {
		this.convertAttachmentToByte();
		return this.coverImageFile;
	}

	public void setCoverImageFile(byte[] coverImageFile) {
		this.coverImageFile = coverImageFile;
	}

	public void convertAttachmentToByte() {
		if (attachment != null){
			byte[] bFile = new byte[(int) attachment.length()];
			 
		     FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(attachment);
				fileInputStream.read(bFile);
			    fileInputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
	        
	        this.coverImageFile = bFile;
		}
	}

	@Override
	public String toString() {
		return "ComicBook [noOfPages=" + noOfPages + ", attachmentFileName="
				+ attachmentFileName + "]";
	}
	
}
