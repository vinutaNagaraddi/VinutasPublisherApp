package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.entity.Office;


public interface OfficeService {
	void addOffice(Office office);
	void updateOffice(Office office);
	void deleteOffice(Long id);
	List<Office> listOffices();
	Office getOffice(Long id);
}
