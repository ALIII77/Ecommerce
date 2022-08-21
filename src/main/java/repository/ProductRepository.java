package repository;

import entity.Product;

import java.util.List;

public interface ProductRepository {


    public List<Product> findProductByOrderId(long id );

}
