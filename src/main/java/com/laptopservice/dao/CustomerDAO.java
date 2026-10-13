package com.laptopservice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.laptopservice.entity.Customer;
import com.laptopservice.util.HibernateUtil;

public class CustomerDAO {
	public void saveCustomer(Customer customer) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.persist(customer);
			transaction.commit();
			System.out.println("Customer saved successfully!");
		} catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void getAllCustomers() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        List<Customer> customers = session
	                .createQuery("from Customer", Customer.class)
	                .getResultList();
	        for (Customer customer : customers) {
	            System.out.println("ID: " + customer.getId());
	            System.out.println("Name: " + customer.getName());
	            System.out.println("Phone: " + customer.getPhone());
	            System.out.println("Email: " + customer.getEmail());
	            System.out.println("Address: " + customer.getAddress());
	            System.out.println("----------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void updateCustomer(int id, String newPhone) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        Customer customer = session.get(Customer.class, id);
	        if (customer != null) {
	            customer.setPhone(newPhone);
	            transaction.commit();
	            System.out.println("Customer updated successfully!");
	        } else {
	            System.out.println("Customer not found!");
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}
	public void deleteCustomer(int id) {

	    Transaction transaction = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	        transaction = session.beginTransaction();

	        Customer customer = session.get(Customer.class, id);

	        if (customer != null) {
	            session.remove(customer);
	            transaction.commit();
	            System.out.println("Customer deleted successfully!");
	        } else {
	            System.out.println("Customer not found!");
	        }

	    } catch (Exception e) {

	        if (transaction != null) {
	            transaction.rollback();
	        }

	        e.printStackTrace();
	    }
	}
}
