package service;

import DBConnection.DBConnection;
import View.menu.CustomerMenu;
import View.menu.UserMenu;
import repository.CustomerRepository;
import repository.ProductRepository;
import repository.implementation.CustomerRepositoryImpl;
import repository.implementation.ProductRepositoryImpl;
import service.implementation.CustomerServiceImpl;

import java.sql.Connection;
import java.util.Scanner;

public class ApplicationConstant {

    public static Scanner input = new Scanner(System.in);
    public static Connection connection = new DBConnection().connect();
    public static CustomerRepository customerRepository = new CustomerRepositoryImpl();
    //public static CustomerRepository customerRepository2 = new CustomerRepositoryImpl2();  implement haye motefavet
    public static CustomerRepositoryImpl customerRepositoryImpl = new CustomerRepositoryImpl();


    //firstMene
    private static final String[] FIRST_MENU = {"signUp", "exit"};
    private static CustomerService customerService = new CustomerServiceImpl();   //ok
    private static UserMenu userMenu = new UserMenu();
    public static final String[] CUSTOMER_MENU = {"list of product","add order"};
    private static ProductRepository productRepository= new ProductRepositoryImpl();
    private static CustomerMenu customerMenu = new CustomerMenu();










    public static Scanner getInput() {
        return input;
    }
    public static Connection getConnection() {
        return connection;
    }
    public static CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    public static CustomerRepositoryImpl getCustomerRepositoryImpl() {
        return customerRepositoryImpl;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }
    public static UserMenu getUserMenu() {
        return userMenu;
    }
    public static ProductRepository getProductRepository() {
        return productRepository;
    }
    public static CustomerMenu getCustomerMenu() {
        return customerMenu;
    }

}
