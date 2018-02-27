package io.javabrains.springbootstarter.repository;

import io.javabrains.springbootstarter.model.Phone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneRepositoryImpl implements PhoneRepositoryCustom{
	
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Phone> getDistinctPhonesByPersonEmail(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Phone> getAllPhonesByNamedQuery() {
		Query query = entityManager.createNamedQuery("Phone.findAll",Phone.class);
		return query.getResultList();
	}
	/*@Override
	public List<Phone> getDistinctPhonesByPersonEmail(String emailId) {
	 String sql = "select * from phone where person_email_id=? group by phone_name";
	 Query query =  entityManager.createNativeQuery(sql,Phone.class);
	 query.setParameter(1, emailId);
	 //String sql = "select * from phone where person_email_id=:email group by (phone_name)";
	 //query.setParameter("email", emailId);
	 return query.getResultList();
	}

*/
	
	
}
