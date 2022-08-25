package service.implementation;

import entity.ProductOrder;
import service.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService {

    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public void addProduct(long productId, long orderId) {
        ProductOrder productOrder = new ProductOrder(productId, orderId);


    }
}
