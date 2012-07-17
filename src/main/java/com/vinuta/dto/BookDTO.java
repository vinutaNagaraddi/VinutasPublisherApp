package main.java.com.vinuta.dto;

import java.io.Serializable;

public class BookDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	private String priceSymbol;
	private String publishDateSymbol;
	
	public String getPriceSymbol() {
		return priceSymbol;
	}
	public void setPriceSymbol(String priceSymbol) {
		this.priceSymbol = priceSymbol;
	}
	public String getPublishDateSymbol() {
		return publishDateSymbol;
	}
	public void setPublishDateSymbol(String publishDateSymbol) {
		this.publishDateSymbol = publishDateSymbol;
	}
}
