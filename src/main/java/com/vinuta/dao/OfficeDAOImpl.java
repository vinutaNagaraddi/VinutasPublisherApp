package main.java.com.vinuta.dao;

import java.util.List;

import main.java.com.vinuta.dao.HibernateDAO;
import main.java.com.vinuta.entity.Office;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRED)
public class OfficeDAOImpl extends HibernateDAO implements OfficeDAO{

	@Override
	public void addOffice(Office office) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(office);
	}

	@Override
	public void updateOffice(Office office) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(office);
	}

	@Override
	public void deleteOffice(Long id) {
		// TODO Auto-generated method stub
		Office office = (Office) this.currentSession().get(Office.class, id);
		this.delete(office);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Office> listOffices() {
		// TODO Auto-generated method stub
		Query officQuery = this.currentSession().createQuery("from Office");
		return officQuery.list();
	}


}
