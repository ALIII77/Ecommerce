package service.implementation;

import View.menu.CustomerMenu;
import entity.Customer;
import repository.CustomerRepository;
import repository.implementation.CustomerRepositoryImpl;
import service.ApplicationConstant;
import service.CustomerService;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository=new CustomerRepositoryImpl();
    CustomerMenu customerMenu=new CustomerMenu();


    @Override
    public Customer login(Customer customer) {
        return customerRepository.read(customer);
    }

    @Override
    public void signup(Customer customer)  {
        try {
            customerRepository.create(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
