package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.dao.OfficeDAO;
import main.java.com.vinuta.entity.Office;

import org.springframework.beans.factory.annotation.Autowired;


public class OfficeServiceImpl implements OfficeService{
	@Autowired
	private OfficeDAO officeDAOImpl;
	
	
	public OfficeDAO getOfficeDAOImpl() {
		return officeDAOImpl;
	}

	public void setOfficeDAOImpl(OfficeDAO officeDAOImpl) {
		this.officeDAOImpl = officeDAOImpl;
	}

	@Override
	public void addOffice(Office office) {
		// TODO Auto-generated method stub
		this.officeDAOImpl.addOffice(office);
	}

	@Override
	public void updateOffice(Office office) {
		// TODO Auto-generated method stub
		this.updateOffice(office);
	}

	@Override
	public void deleteOffice(Long id) {
		// TODO Auto-generated method stub
		this.officeDAOImpl.deleteOffice(id);
	}

	@Override
	public List<Office> listOffices() {
		// TODO Auto-generated method stub
		return this.officeDAOImpl.listOffices();
	}
}
