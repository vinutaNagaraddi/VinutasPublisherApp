package main.java.com.vinuta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="ADDRESS", schema ="PUBLISHERAPP")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;
	
	@Column(nullable=false)
	private String address1;
	
	private String address2;
	
	@Column(nullable=false)
	private String city;
	
	@Column(length=2, nullable=false)
	private String state;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@OneToOne(mappedBy="address")
	private Office office;
	
	public Address(){};
	
	public Address(String address1, String address2,
			String city, String state, String zipCode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", version=" + version + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
}
