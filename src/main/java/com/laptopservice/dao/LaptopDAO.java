package com.laptopservice.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.laptopservice.entity.Laptop;
import com.laptopservice.util.HibernateUtil;

public class LaptopDAO {
    public void saveLaptop(Laptop laptop) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(laptop);
            transaction.commit();
            System.out.println("Laptop saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void getAllLaptops() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Laptop> laptops = session
                    .createQuery("from Laptop", Laptop.class)
                    .getResultList();

            for (Laptop laptop : laptops) {

                System.out.println("ID: " + laptop.getId());
                System.out.println("Brand: " + laptop.getBrand());
                System.out.println("Model: " + laptop.getModel());
                System.out.println("Serial Number: " + laptop.getSerialNumber());
                System.out.println("Problem: " + laptop.getProblem());
                System.out.println("Customer: " + laptop.getCustomer().getName());

                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateLaptop(int id, String newProblem) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Laptop laptop = session.get(Laptop.class, id);

            if (laptop != null) {

                laptop.setProblem(newProblem);

                transaction.commit();

                System.out.println("Laptop updated successfully!");

            } else {

                System.out.println("Laptop not found!");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
    public void deleteLaptop(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Laptop laptop = session.get(Laptop.class, id);

            if (laptop != null) {

                session.remove(laptop);

                transaction.commit();

                System.out.println("Laptop deleted successfully!");

            } else {

                System.out.println("Laptop not found!");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}