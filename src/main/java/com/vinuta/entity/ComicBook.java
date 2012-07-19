package main.java.com.vinuta.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
	
	@Lob
	@Column(name="cover_image_file")
	private byte[] attachmentArray;
	
	@Transient
	private File attachment;
	
	@Column(name="cover_image_file_Name")
	private String attachmentFileName;
	
	@Column(name="cover_image_content_type")
	private String attachmentContentType;
	
	@Transient
	private File updatedAttachment;
	@Transient
	private String updatedAttachmentFileName;
	@Transient
	private String updatedAttachmentContentType;
	
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

	
	public File getUpdatedAttachment() {
		return updatedAttachment;
	}

	public void setUpdatedAttachment(File updatedAttachment) {
		this.updatedAttachment = updatedAttachment;
	}

	public String getUpdatedAttachmentFileName() {
		return updatedAttachmentFileName;
	}

	public void setUpdatedAttachmentFileName(String updatedAttachmentFileName) {
		this.updatedAttachmentFileName = updatedAttachmentFileName;
	}

	public String getUpdatedAttachmentContentType() {
		return updatedAttachmentContentType;
	}

	public void setUpdatedAttachmentContentType(String updatedAttachmentContentType) {
		this.updatedAttachmentContentType = updatedAttachmentContentType;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public byte[] getAttachmentArray() {
		return attachmentArray;
	}

	public void setAttachmentArray(byte[] attachmentArray) {
		this.attachmentArray = attachmentArray;
	}

	@Override
	public String toString() {
		return "ComicBook [noOfPages=" + noOfPages + ", attachment="
				+ attachment + ", attachmentFileName=" + attachmentFileName
				+ ", attachmentContentType=" + attachmentContentType + "] "
				+ super.toString();
	}

	public void convertFileToByte() {
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
	        this.attachmentArray = bFile;
		}
	}
	
	public void convertUpdatedFileToByte(){
		if (updatedAttachment != null){
			byte[] bFile = new byte[(int) updatedAttachment.length()];
			 
		     FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(updatedAttachment);
				fileInputStream.read(bFile);
			    fileInputStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        this.attachmentArray = bFile;
	        this.attachmentContentType = this.updatedAttachmentContentType;
	        this.attachmentFileName = this.updatedAttachmentFileName;
		}
	}
}
