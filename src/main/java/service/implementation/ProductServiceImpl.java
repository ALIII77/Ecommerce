package service.implementation;

import entity.Product;
import repository.ProductRepository;
import repository.implementation.ProducOrderRepositoryImpl;
import repository.implementation.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository = new ProductRepositoryImpl();

    public List<Product> allProduct() {
        return productRepository.allProduct();

    }

    public Product read(Long id) {
        Product product = new Product();
        return productRepository.read(product.getId());
    }

}
