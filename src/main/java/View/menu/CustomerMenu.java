package View.menu;

import service.ApplicationConstant;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {

    public void customerMenu() throws SQLException {



        Printer.firstMenu();
        int getInput = ApplicationConstant.getInput().nextInt();
        switch (getInput) {
            case 1:
                login();
                break;
            case 2:
                signup();
                break;
        }

    }



        private static String[] login()
    {
        System.out.println("Enter your Username and Password");
        String [] userpassword= ApplicationConstant.getInput().nextLine().split(" ");
        if (userpassword[0].equals("0"))
        {
            return null;
        }
        if (userpassword.length!=2)
        {
            throw new IllegalArgumentException("Invalid Entry!");
        }
        else return userpassword;



    }



    }

