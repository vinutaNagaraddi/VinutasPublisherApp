package main.java.com.vinuta.service;

import java.util.List;

import main.java.com.vinuta.dao.MagazineDAO;
import main.java.com.vinuta.entity.Magazine;

import org.springframework.beans.factory.annotation.Autowired;


public class MagazineServiceImpl implements MagazineService{
	@Autowired
	private MagazineDAO magazineDAOImpl;
	
	public MagazineDAO getMagazineDAOImpl() {
		return magazineDAOImpl;
	}

	public void setMagazineDAOImpl(MagazineDAO magazineDAOImpl) {
		this.magazineDAOImpl = magazineDAOImpl;
	}

	@Override
	public void addMagazine(Magazine magazine){
		// TODO Auto-generated method stub
		this.magazineDAOImpl.addMagazine(magazine);
	}

	@Override
	public void updateMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		this.magazineDAOImpl.updateMagazine(magazine);
	}

	@Override
	public void deleteMagazine(Long id) {
		// TODO Auto-generated method stub
		this.magazineDAOImpl.deleteMagazine(id);
	}

	@Override
	public List<Magazine> listMagazines() {
		// TODO Auto-generated method stub
		return this.magazineDAOImpl.listMagazines();
	}

	@Override
	public Magazine getMagazine(Long id) {
		// TODO Auto-generated method stub
		return this.magazineDAOImpl.getMagazine(id);
	}

}
