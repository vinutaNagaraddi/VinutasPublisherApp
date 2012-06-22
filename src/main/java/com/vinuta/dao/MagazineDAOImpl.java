package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.entity.Magazine;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRED)
public class MagazineDAOImpl extends HibernateDAO implements MagazineDAO{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void addMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(magazine);
	}

	@Override
	public void updateMagazine(Magazine magazine) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(magazine);
	}

	@Override
	public void deleteMagazine(Long id) {
		// TODO Auto-generated method stub
		this.delete(getMagazineById(id));
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Magazine> listMagazines() {
		// TODO Auto-generated method stub
		Query magazineQuery = this.currentSession().createQuery("from Magazine");
		return magazineQuery.list();
	}

	@Override
	public Magazine getMagazine(Long id) {
		// TODO Auto-generated method stub
		return getMagazineById(id);
	}
	
	private Magazine getMagazineById(Long id) {
		Magazine magazine = (Magazine) this.currentSession().get(Magazine.class, id);
		return magazine;
	}

}
