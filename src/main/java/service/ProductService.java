package service;

import entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> allProduct();
    public Product read(Long id);

}
