package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

import com.code.entity.Category;
import com.code.entity.Product;

public class AddProduct {

    private SessionFactory sessionFactory;

    // Constructor with SessionFactory object
    public AddProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // Create the session object
        Session session = sessionFactory.getCurrentSession();

        // Start the transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create categories
            Category category1 = new Category();
            category1.setName("Electronics");
            category1.setDescription("Electronic gadgets and devices");
            session.save(category1);

            Category category2 = new Category();
            category2.setName("Fashion");
            category2.setDescription("Clothing and accessories");
            session.save(category2);
            
            Category category3 = new Category();
            category3.setName("Home");
            category3.setDescription("Home & Appliances");
            session.save(category3);

            // Create products
            Product product1 = new Product("Head Phone", BigDecimal.valueOf(499.99), 50, category1);
            session.persist(product1);

            Product product2 = new Product("Laptop", BigDecimal.valueOf(8999.99), 30, category1);
            session.persist(product2);

            Product product3 = new Product("Dress", BigDecimal.valueOf(899.99), 100, category2);
            session.persist(product3);
            
            Product product4 = new Product("Bottle", BigDecimal.valueOf(899.99), 100, category3);
            session.persist(product4);

            // Commit transaction
            transaction.commit();

            // Close the session
            session.close();
            System.out.println("Products added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of errors
            }
            session.close(); // Ensure the session is closed even if an error occurs
        }
    }
}