package repository;

import entity.Customer;
import entity.Order;

import java.sql.SQLException;

public interface CustomerRepository {




    Customer findCustomerById(long id) throws SQLException;
    boolean findCustomerByUsername(String username) throws SQLException;

}
