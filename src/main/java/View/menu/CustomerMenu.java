package View.menu;

import service.ApplicationConstant;

import java.sql.SQLException;

public class CustomerMenu {

    public void customerMenu() throws SQLException {
        Printer.print(ApplicationConstant.CUSTOMER_MENU);
        while (true) {
            int input = ApplicationConstant.getInput().nextInt();

            switch (input) {
                case 1 -> ApplicationConstant.getProductRepo().allProduct();
                case 2 -> ApplicationConstant.getProductRepo().findProByOrderID(ApplicationConstant.getInput().nextLong());
                case 3 -> System.exit(1);
                default -> System.out.println("enter correct number");
            }
        }
    }
}
