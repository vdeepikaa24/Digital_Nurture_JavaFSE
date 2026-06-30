package com.cognizant.handson2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        // Build the factory from the XML file
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        ManageEmployee me = new ManageEmployee();
        // You are passing: "Deepikaa" (fname), "V" (lname), 50000 (salary)
        me.addEmployee("Deepika", "V", 50000);
    }

    public void addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            String fullName = fname + " " + lname;
            
            // Pass only the name; let Hibernate handle the auto-increment ID
            Employee emp = new Employee(fullName);
            
            session.persist(emp); 
            tx.commit();
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}