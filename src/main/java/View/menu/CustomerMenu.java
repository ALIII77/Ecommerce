package View.menu;

import entity.Customer;
import service.ApplicationConstant;
import service.implementation.ProductServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {

    public static void menu() {
        Printer.firstMenu();
        int getInput = ApplicationConstant.getInput().nextInt();
        switch (getInput) {
            case 1:

                userMenu(login());
                break;
            case 2:
                signup();
                break;
        }
    }
    public static void userMenu(Customer customer)
    {
        Printer.customerMenu();
        int i = ApplicationConstant.getInput().nextInt();
        switch (i)
        {
            case 1 :
                System.out.println( ApplicationConstant.getProductService().allProduct());
                break;
            case 2 :
        }
    }

    public static void signup() {
        Customer newCustomer = new Customer();
        System.out.println("Enter your name");
        String name = ApplicationConstant.getInput().nextLine();
        newCustomer.setName(name);
        System.out.println("Enter your username");
        String username = ApplicationConstant.getInput().nextLine();
        newCustomer.setUsername(username);
        System.out.println("Enter your password");
        String password = ApplicationConstant.getInput().nextLine();
        newCustomer.setUsername(password);
        ApplicationConstant.getCustomerService().signup(newCustomer);

    }


    private static Customer login() {
        while (true) {
            System.out.println("Enter your Username and Password");
            String[] userpassword = ApplicationConstant.getInput().nextLine().split(" ");
            if (userpassword[0].equals("0")) {
                return null;
            }
            if (userpassword.length != 2) {
                System.out.println("Invalid Input!");
                continue;
            }
            try {
                return ApplicationConstant.getCustomerService().login(new Customer(userpassword[0], userpassword[1]));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}