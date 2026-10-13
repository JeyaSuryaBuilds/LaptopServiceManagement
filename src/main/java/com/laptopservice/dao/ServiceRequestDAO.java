package com.laptopservice.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.laptopservice.entity.Laptop;
import com.laptopservice.entity.ServiceRequest;
import com.laptopservice.util.HibernateUtil;

public class ServiceRequestDAO {
    public void saveServiceRequest(ServiceRequest serviceRequest) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(serviceRequest);

            transaction.commit();

            System.out.println("Service Request saved successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void getAllServiceRequests() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<ServiceRequest> requests = session
                    .createQuery("from ServiceRequest", ServiceRequest.class)
                    .getResultList();

            for (ServiceRequest request : requests) {

                System.out.println("ID: " + request.getId());
                System.out.println("Service Type: " + request.getServiceType());
                System.out.println("Description: " + request.getDescription());
                System.out.println("Cost: " + request.getCost());
                System.out.println("Status: " + request.getStatus());

                if (request.getLaptop() != null) {
                    System.out.println("Laptop: "
                            + request.getLaptop().getBrand()
                            + " " + request.getLaptop().getModel());
                }

                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateServiceRequest(int id, String newStatus, double newCost) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            ServiceRequest request = session.get(ServiceRequest.class, id);

            if (request != null) {

                request.setStatus(newStatus);
                request.setCost(newCost);

                transaction.commit();

                System.out.println("Service Request updated successfully!");

            } else {

                System.out.println("Service Request not found!");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void deleteServiceRequest(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            ServiceRequest request = session.get(ServiceRequest.class, id);

            if (request != null) {

                session.remove(request);

                transaction.commit();

                System.out.println("Service Request deleted successfully!");

            } else {

                System.out.println("Service Request not found!");
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