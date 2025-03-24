package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.math.BigDecimal;
import com.code.entity.Category;
import com.code.entity.Product;

public class AddProduct {

    private final SessionFactory sessionFactory;

    // Constructor to inject SessionFactory
    public AddProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProducts() {
        // Open session and start transaction
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                // Create categories
                Category category1 = new Category("Electronics", "Electronic gadgets and devices");
                Category category2 = new Category("Fashion", "Clothing and accessories");
                Category category3 = new Category("Home", "Home & Appliances");

                // Persist categories
                session.persist(category1);
                session.persist(category2);
                session.persist(category3); // ✅ Fixed the bug

                // Create products
                Product product1 = new Product("Headphones", BigDecimal.valueOf(499.99), 50, category1);
                Product product2 = new Product("Laptop", BigDecimal.valueOf(899.99), 30, category1);
                Product product3 = new Product("Dress", BigDecimal.valueOf(919.99), 100, category2);
                Product product4 = new Product("Necklace", BigDecimal.valueOf(449), 100, category2);
                Product product5 = new Product("Bottle", BigDecimal.valueOf(28.99), 100, category3);

                // Persist products
                session.persist(product1);
                session.persist(product2);
                session.persist(product3);
                session.persist(product4);
                session.persist(product5);

                // Commit transaction
                transaction.commit();
                System.out.println("Products added successfully!");

            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback(); // Rollback in case of failure
                }
            }
        } // Session automatically closed due to try-with-resources
    }
}
