package main.java.com.vinuta.action;

import java.util.List;

import main.java.com.vinuta.entity.Address;
import main.java.com.vinuta.entity.Contact;
import main.java.com.vinuta.entity.Office;
import main.java.com.vinuta.service.OfficeService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OfficeAction extends ActionSupport{
	
		private Logger logger = Logger.getLogger(this.getClass());
		
		@Autowired
		private OfficeService officeServiceImpl;

		public OfficeService getOfficeServiceImpl() {
			return officeServiceImpl;
		}

		public void setOfficeServiceImpl(OfficeService officeServiceImpl) {
			this.officeServiceImpl = officeServiceImpl;
		}
		
		public String addOffice(){
			Contact weekdayContact = new Contact("recipient1", "phone1", "email1");
			Contact weekendContact = new Contact("recipient2", "phone2", "email2");
			Address address = new Address("address1", "address2", "city", "tx", "12334");
			
			Office office = new Office(weekdayContact, weekendContact, address);
			
			this.officeServiceImpl.addOffice(office);
			
			return SUCCESS;
		}
	
		public String updateOffice(){
			return SUCCESS;
		}
		
		public String deleteOffice(){
			this.officeServiceImpl.deleteOffice(new Long(1));
			return SUCCESS;
		}	
		
		public String listOffices(){
			List<Office> offices = this.officeServiceImpl.listOffices();
			for (Office office : offices){
				logger.debug(office.toString());
			}
			return SUCCESS;
		}
}
