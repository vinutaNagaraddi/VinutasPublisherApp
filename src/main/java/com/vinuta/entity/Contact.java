package main.java.com.vinuta.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	public Contact(){};
	
	public Contact(String recipient, String phone, String emailAddress) {
		super();
		this.recipient = recipient;
		this.phone = phone;
		this.emailAddress = emailAddress;
	}

	private String recipient;
	private String phone;
	
	@Column(name="email_address")
	private String emailAddress;

	@Override
	public String toString() {
		return "Contact [recipient=" + recipient + ", phone=" + phone
				+ ", emailAddress=" + emailAddress + "]";
	}
	
}
