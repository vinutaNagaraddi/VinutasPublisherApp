package main.java.com.vinuta.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import main.java.com.vinuta.entity.Contact;

@Entity
@Table(name="OFFICE", schema ="PUBLISHERAPP")
public class Office implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Version
	private Integer version;

	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="firstName", column=@Column(name="contact_firstName")),
		@AttributeOverride(name="lastName", column=@Column(name="contact_lastName")),
		@AttributeOverride(name="phoneNumber", column=@Column(name="contact_phoneNumber")),
		@AttributeOverride(name="emailAddress", column=@Column(name="contact_emailAddress"))
	})
	private Contact contact;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="address_id")
	private Address address;
	
	public Office(){};
	
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", version=" + version + ", officeName="
				+ name + ", officePhoneNumber=" + phoneNumber
				+ ", weekdayContact=" + contact + ", address=" + address
				+ "]";
	}
}
