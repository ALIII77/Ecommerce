package repository;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {

    public List<Product> allProduct() throws SQLException;




}
