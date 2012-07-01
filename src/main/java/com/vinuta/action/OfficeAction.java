package main.java.com.vinuta.action;

import java.util.List;


import main.java.com.vinuta.entity.Address;
import main.java.com.vinuta.entity.Contact;
import main.java.com.vinuta.entity.Office;
import main.java.com.vinuta.service.OfficeService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@SuppressWarnings("serial")
public class OfficeAction extends PublisherAppAction{
	
		private Logger logger = Logger.getLogger(this.getClass());
		private Office office;
		private List<Office> offices;
		
		@Autowired
		private OfficeService officeServiceImpl;

		public OfficeService getOfficeServiceImpl() {
			return officeServiceImpl;
		}

		public void setOfficeServiceImpl(OfficeService officeServiceImpl) {
			this.officeServiceImpl = officeServiceImpl;
		}
		
		public Office getOffice() {
			return office;
		}

		public void setOffice(Office office) {
			this.office = office;
		}

		public List<Office> getOffices() {
			return offices;
		}

		public void setOffices(List<Office> offices) {
			this.offices = offices;
		}

		public String addOffice(){
			this.officeServiceImpl.addOffice(office);
			return SUCCESS;
		}
	
		public String updateOffice(){
			this.officeServiceImpl.updateOffice(office);
			return SUCCESS;
		}
		
		public String deleteOffice(){
			this.officeServiceImpl.deleteOffice(office.getId());
			return SUCCESS;
		}	
		
		public String getOfficeById(){
			this.office = this.officeServiceImpl.getOffice(office.getId());
			return SUCCESS;
		}
		
		public String listOffices(){
			this.offices = this.officeServiceImpl.listOffices();
			return SUCCESS;
		}
}
