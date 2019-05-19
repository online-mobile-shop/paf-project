package com.login.LoginManager;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.login.Login.beans.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(customer!=null) {
			try {
				session.save(customer);
				tx.commit();
				session.close();
			}catch(Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}

	@Override
	public Customer loginCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from com.login.login.beans.Customer as c where c.c_mail=? and c.c_password=?";
		try {
			Query query = session.createQuery(sql);
			query.setParameter(0, customer.getC_mail());
			query.setParameter(1, customer.getC_password());
			customer = (Customer) ((org.hibernate.query.Query) query).uniqueResult();
			tx.commit();
			session.close();	
		}catch(Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return customer;
		
	}

}
