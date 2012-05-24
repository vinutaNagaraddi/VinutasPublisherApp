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
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="recipient", column=@Column(name="weekday_contact_recipient")),
		@AttributeOverride(name="phone", column=@Column(name="weekday_contact_phone")),
		@AttributeOverride(name="emailAddress", column=@Column(name="weekday_contact_emailAddress"))
	})
	private Contact weekdayContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="recipient", column=@Column(name="weekend_contact_recipient")),
		@AttributeOverride(name="phone", column=@Column(name="weekend_contact_phone")),
		@AttributeOverride(name="emailAddress", column=@Column(name="weekend_contact_emailAddress"))
	})
	private Contact weekendContact;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="address_id")
	private Address address;
	
	public Office(){};
	
	public Office(Contact weekdayContact, Contact weekendContact,
			Address address) {
		super();
		this.weekdayContact = weekdayContact;
		this.weekendContact = weekendContact;
		this.address = address;
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
	public Contact getWeekdayContact() {
		return weekdayContact;
	}
	public void setWeekdayContact(Contact weekdayContact) {
		this.weekdayContact = weekdayContact;
	}
	public Contact getWeekendContact() {
		return weekendContact;
	}
	public void setWeekendContact(Contact weekendContact) {
		this.weekendContact = weekendContact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Office [id=" + id + ", version=" + version
				+ ", weekdayContact=" + weekdayContact + ", weekendContact="
				+ weekendContact + ", address=" + address + "]";
	}
}
