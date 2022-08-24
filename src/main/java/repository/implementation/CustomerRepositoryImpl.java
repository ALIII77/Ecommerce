package repository.implementation;

import entity.Customer;
import entity.Order;
import repository.BaseRepository;
import repository.CustomerRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepositoryImpl implements CustomerRepository , BaseRepository<Customer> {




    @Override
    public Customer findCustomerById(long id) throws SQLException {
        Customer foundCustomer = new Customer();
        String sqlQuery= """
                SELECT * 
                FROM customer
                WHERE id = ?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                foundCustomer.setId(rs.getLong(1));
                foundCustomer.setUsername(rs.getString(2));
                foundCustomer.setPassword(rs.getString(3));
            }
            return foundCustomer;

    }

    @Override
    public boolean findCustomerByUsername(String username) throws SQLException {
        String sqlQuery = """
                select * from customer where username = ?
                """;
        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // System.out.println(username + " ALREADY EXISTS");
            return true;
        }else {
            //System.out.println("username added successfully");

            return false;
        }


    }





    @Override
    public Customer create(Customer customer) throws SQLException {
        if (findCustomerByUsername(customer.getUsername()))
        {
            System.out.println("username exists");
            return null;
        }
        else
        {
            String sql = """
                        insert  into customer (username,password) values (?,?)
                         """;
            PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());

            ps.executeUpdate();
            if (ps.getGeneratedKeys().next()) {
                customer.setId(ps.getGeneratedKeys().getLong(1));
            }
            System.out.println("User Created Successfully");
            return customer;
        }
    }

    @Override
    public Customer read(Customer customer) {


        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }


}

