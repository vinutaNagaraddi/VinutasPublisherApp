package main.java.com.vinuta.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import main.java.com.vinuta.entity.Address;
import main.java.com.vinuta.entity.Contact;
import main.java.com.vinuta.entity.Office;
import main.java.com.vinuta.service.OfficeService;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;

@Scope("prototype")
@SuppressWarnings("serial")
public class OfficeAction extends PublisherAppAction{
	
		private Logger logger = Logger.getLogger(this.getClass());
		private Office office;
		private List<Office> offices;
		private static Map<String,String> usStates = new TreeMap<String,String>();
		
		static{
			usStates.put("AL", "Alabama");
			usStates.put("AK", "Alaska");
			usStates.put("AZ", "Arizona");
			usStates.put("AR", "Arkansas");
			usStates.put("CA","California");
			usStates.put("CO", "Colorado");
			usStates.put("CT","Connecticut");
			usStates.put("DE","Delaware");
			usStates.put("DC", "District of Columbia");
			usStates.put("FL", "Florida");
			usStates.put("GA", "Georgia");
			usStates.put("HI", "Hawaii");
			usStates.put("ID", "Idaho");
			usStates.put("IL", "Illinois");
			usStates.put("IN", "Indiana");
			usStates.put("IA", "Iowa");
			usStates.put("KS", "Kansas");
			usStates.put("KY", "Kentucky");
			usStates.put("LA", "Louisiana");
			usStates.put("ME", "Maine");
			usStates.put("MD", "Maryland");
			usStates.put("MA", "Massachusetts");
			usStates.put("MI", "Michigan");
			usStates.put("MN", "Minnesota");
			usStates.put("MS", "Mississippi");
			usStates.put("MO", "Missouri");
			usStates.put("MT", "Montana");
			usStates.put("NE", "Nebraska");
			usStates.put("NV", "Nevada");
			usStates.put("NH", "New Hampshire");
			usStates.put("NJ", "New Jersey");
			usStates.put("NM", "New Mexico");
			usStates.put("NY", "New York");
			usStates.put("NC", "North Carolina");
			usStates.put("ND", "North Dakota");
			usStates.put("OH", "Ohio");
			usStates.put("OK", "Oklahoma");
			usStates.put("OR", "Oregon");
			usStates.put("PA", "Pennsylvania");
			usStates.put("RI", "Rhode Island");
			usStates.put("SC", "South Carolina");
			usStates.put("SD", "South Dakota");
			usStates.put("TN", "Tennessee");
			usStates.put("TX", "Texas");
			usStates.put("UT", "Utah");
			usStates.put("VT", "Vermont");
			usStates.put("VA", "Virginia");
			usStates.put("WA", "Washington");
			usStates.put("WV", "West Virginia");
			usStates.put("WI", "Wisconsin");
			usStates.put("WY", "Wyoming");
		}
		
		
		@Autowired
		private OfficeService officeServiceImpl;

		public OfficeService getOfficeServiceImpl() {
			return officeServiceImpl;
		}

		public void setOfficeServiceImpl(OfficeService officeServiceImpl) {
			this.officeServiceImpl = officeServiceImpl;
		}
		
		public Map<String, String> getUsStates() {
			return usStates;
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
			try{
				this.officeServiceImpl.addOffice(office);
			}
			catch(ConstraintViolationException ue){
				this.addActionError(this.getText("unique.office.exception"));
				return INPUT;
			}
			
			return SUCCESS;
		}
	
		public String updateOffice(){
			try{
				this.officeServiceImpl.updateOffice(office);
			}
			catch(DataIntegrityViolationException ue){
				this.addActionError(this.getText("unique.office.exception"));
				return INPUT;
			}
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
