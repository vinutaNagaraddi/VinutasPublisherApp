package main.java.com.vinuta.dto;

import java.io.Serializable;

import main.java.com.vinuta.entity.Magazine;

public class MagazineDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Magazine magazine;
	private String priceSymbol;
	private String publishDateSymbol;
	private String availableOnlineBooleanValue;
	
	
	public Magazine getMagazine() {
		return magazine;
	}
	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}
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
	public String getAvailableOnlineBooleanValue() {
		return availableOnlineBooleanValue;
	}
	public void setAvailableOnlineBooleanValue(String availableOnlineBooleanValue) {
		this.availableOnlineBooleanValue = availableOnlineBooleanValue;
	}
}
