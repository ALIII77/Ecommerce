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

public class CustomerRepositoryImpl implements CustomerRepository {


    @Override
    public Customer findCustomerById(long id) throws SQLException {
        Customer foundCustomer = new Customer();
        String sqlQuery = """
                SELECT * 
                FROM customer
                WHERE id = ?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ps.setLong(1, id);
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
        } else {
            //System.out.println("username added successfully");

            return false;
        }


    }

    public Customer findCustomerByUsername2(String username) throws SQLException {
        Customer resutlCustomer = new Customer();
        String sqlQuery = """
                select * from customer where username = ?
                """;
        PreparedStatement stm = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // System.out.println(username + " ALREADY EXISTS");
            resutlCustomer.setId(rs.getLong("id"));
            resutlCustomer.setName(rs.getString("name"));
            resutlCustomer.setUsername(rs.getString("username"));
            resutlCustomer.setPassword(rs.getString("password"));
            return resutlCustomer;
        } else {
            System.out.println("username not found");                             //System.out.println("username added successfully");
            return null;
        }
    }


    @Override
    public void create(Customer customer) {
        String sql = """
                insert  into customer (name,username,password) values (?,?,?)
                 """;
        try (PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getUsername());
            ps.setString(3, customer.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys(); //ok
            rs.next();
            customer.setId(rs.getLong(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Customer read(Customer customer) {
        String sqlQuery = """
                SELECT id,name FROM customer
                WHERE username=? and password = ? 
                """;
        try (PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);) {
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ResultSet rs = ps.executeQuery();
            rs.next();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException("user not exists!!!");
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        throw new RuntimeException();
    }

    @Override
    public void delete(Customer customer) {
        throw new RuntimeException();
    }

    public boolean checkExists(String[] userpassword) throws SQLException {
        if (findCustomerByUsername(userpassword[0])) {
                //rea
        }

        return false;
    }


}

