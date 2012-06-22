package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.entity.Magazine;


public interface MagazineService {
	void addMagazine(Magazine magazine);
	void updateMagazine(Magazine magazine);
	void deleteMagazine(Long id);
	List<Magazine> listMagazines();
	Magazine getMagazine(Long id);
}
