package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements ICustomerDAO
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() 
	{
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customerList = 
				session.createQuery("from Customer order by lastName", Customer.class)
				.getResultList();
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customer)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.save(customer);
	}

}
