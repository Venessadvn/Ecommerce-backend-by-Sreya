# Hibernate E-Commerce System

## Overview

This repository contains a Hibernate-based CRUD application that performs operations on Categories, Products, Users, and Orders.

## Features

- Insert new **Categories, Products, and Users**
- Create **Orders** with multiple **OrderDetails**
- Fetch **Orders** along with associated **Users and Products**
-  CRUD Operations
- Entity Relationships
- Optional Enhancements:
    - Named Queries
    - Soft Delete
    - Pagination

## Prerequisites

Ensure you have the following installed on your system:

- **Java JDK (Version 17 or later)**
- **Apache Maven**
- **MySQL Database**
- **Eclipse**
- **Git**

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Venessadvn/hibernate-crud.git
cd hibernate-crud
```

### 2. Configure Database

- Create a MySQL database:

```sql
CREATE DATABASE ecommerce_db;
```

- Update **hibernate.cfg.xml** with your database credentials:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/ecommerce_db</property>
<property name="hibernate.connection.username">your-username</property>
<property name="hibernate.connection.password">your-password</property>
```

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.code.demo.Main"
```

## Project Structure

```
hibernate-crud/
│── src/main/java/com/code/entity/        # Entity Classes
│── src/main/java/com/code/dao/           # DAO Layer
│── src/main/java/com/code/demo/          # Main Application
│── src/test/java/com/code/               # Test Cases
│── pom.xml                                # Maven Configuration
│── schema.sql                             # Database Schema
│── README.md                              # Project Documentation
```

## CRUD Operations

### Insert a New Product

```java
Product product = new Product("Smartphone", BigDecimal.valueOf(699.99), 25, category);
session.save(product);
```

### Fetch Orders with Users and Products

```java
List<Order> orders = session.createQuery("from Order o join fetch o.user join fetch o.orderDetails", Order.class).getResultList();
```

## Running Tests

```bash
mvn test
```

## Contributing

Feel free to submit issues or pull requests to improve this project.


## Author
Sreya Dhar
