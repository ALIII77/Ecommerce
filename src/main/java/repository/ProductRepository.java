package repository;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository extends BaseRepository<Product,Long> {

    public List<Product> allProduct();








}
