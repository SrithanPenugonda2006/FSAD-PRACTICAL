package com.inventory.main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PRODUCT INVENTORY MENU =====");
            System.out.println("1. Add New Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product Price / Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProduct();
                    break;

                case 3:
                    updateProduct();
                    break;

                case 4:
                    deleteProduct();
                    break;

                case 5:
                    HibernateUtil.getSessionFactory().close();
                    System.out.println("Application Closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }

    static void addProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product Name: ");
        String name = sc.next();

        System.out.print("Enter Description: ");
        String desc = sc.next();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Product p = new Product(name, desc, price, qty);
        session.save(p);

        tx.commit();
        session.close();

        System.out.println("Product Added Successfully");
    }

    static void viewProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
        } else {
            System.out.println("Product Not Found");
        }

        session.close();
    }

    static void updateProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {
            System.out.print("Enter New Price: ");
            p.setPrice(sc.nextDouble());

            System.out.print("Enter New Quantity: ");
            p.setQuantity(sc.nextInt());

            session.update(p);
            tx.commit();
            System.out.println("Product Updated Successfully");
        } else {
            System.out.println("Product Not Found");
        }

        session.close();
    }

    static void deleteProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = session.get(Product.class, id);

        if (p != null) {
            session.delete(p);
            tx.commit();
            System.out.println("Product Deleted Successfully");
        } else {
            System.out.println("Product Not Found");
        }

        session.close();
    }
}