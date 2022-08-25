package repository.implementation;

import entity.Product;
import repository.BaseRepository;
import repository.ProductRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public void create(Product product) {


    }

    @Override
    public Product read(Long id) {
        Product product = new Product();
        String sqlQuery = """
                SELECT * FROM product
                WHERE  id = ?
                """;
        try (PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            product.setName(rs.getString(2));
            product.setCategory(rs.getString(3));
            product.setDescription(rs.getString(4));
            product.setPrice(rs.getDouble(5));
            product.setQuantity(rs.getLong(6));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }


    @Override
    public List<Product> allProduct() {
        List<Product> resultProductList = new ArrayList<>();
        String sqlQuery = """
                SELECT * FROM product
                
                """;
        try (PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultProductList.add(getProduct(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultProductList;
    }

    private Product getProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDouble(5),
                rs.getLong(6));
    }

}
