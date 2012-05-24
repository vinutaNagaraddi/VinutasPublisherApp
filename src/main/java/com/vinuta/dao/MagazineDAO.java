package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Magazine;


public interface MagazineDAO {
	void addMagazine(Magazine magazine);
	void updateMagazine(Magazine magazine);
	void deleteMagazine(Long id);
	List<Magazine> listMagazines();
}
