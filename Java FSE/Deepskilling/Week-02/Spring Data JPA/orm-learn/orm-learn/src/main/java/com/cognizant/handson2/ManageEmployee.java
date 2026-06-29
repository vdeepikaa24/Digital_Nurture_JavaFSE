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
        me.addEmployee("Deepika", "V", 50000);
    }

    public void addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction(); // Start
            Employee emp = new Employee(fname, lname, salary);
            session.save(emp);               // Operation
            tx.commit();                     // Permanent save
        } catch (Exception e) {
            if (tx != null) tx.rollback();   // Undo on failure
            e.printStackTrace();
        } finally {
            session.close();                 // Clean up connection
        }
    }
}