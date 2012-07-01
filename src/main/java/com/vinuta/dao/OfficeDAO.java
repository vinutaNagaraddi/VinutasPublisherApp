package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Office;


public interface OfficeDAO {
	void addOffice(Office office);
	void updateOffice(Office office);
	void deleteOffice(Long id);
	List<Office> listOffices();
	Office getOffice(Long id);
}
