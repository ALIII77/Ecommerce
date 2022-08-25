package View.menu;

import entity.Product;

import java.util.List;

public class Printer {

    public static void firstMenu() {
        System.out.println("""
                1 - Login
                2 - Signup
                3 - Exit              
                  """);
    }

    public static void customerMenu()
    {
        System.out.println("""
                1 - Show All Products 
                2 - Show Order
                """);
    }

    public static void productMenu(List<Product> productList)
    {
        for (int i=0;i<productList.size();i++)
        {
            System.out.println(productList.get(i));
        }
    }


    }
