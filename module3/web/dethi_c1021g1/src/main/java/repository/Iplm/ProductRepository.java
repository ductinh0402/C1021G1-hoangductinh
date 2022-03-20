package repository.Iplm;


import model.Product;
import repository.IProductRepository;
import service.IProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from product  join category on product.id_category=category.id_category;");
            resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setNameProduct(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price_product"));
                product.setQuantity(resultSet.getString("quantity_product"));
                product.setColor(resultSet.getString("color_product"));
                product.setDescription(resultSet.getString("description_product"));
                product.setIdCategory(resultSet.getInt("id_category"));
                product.setNameCategory(resultSet.getString("name_category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void addNew(Product product) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("insert into product(id_product,name_product,price_product,quantity_product" +
                            ",color_product,description_product,id_category)  values (?,?,?,?,?,?,?)");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, product.getIdProduct());
            preparedStatement.setString(2, product.getNameProduct());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setInt(7, product.getIdCategory());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement("select * from product where id_product = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setIdProduct(id);
                product.setNameProduct(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price_product"));
                product.setQuantity(resultSet.getString("quantity_product"));
                product.setColor(resultSet.getString("color_product"));
                product.setDescription(resultSet.getString("description_product"));
                product.setIdCategory(resultSet.getInt("id_category"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("update product set  name_product = ?,price_product = ?,quantity_product = ?," +
                            "color_product = ?,description_product= ?,id_category = ?" +
                            " where id_product = ?");
        preparedStatement.setString(1, product.getNameProduct());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, product.getIdCategory());
        preparedStatement.setInt(7, product.getIdProduct());
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("delete from product where id_product = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from product where name_product like ?");
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setNameProduct(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price_product"));
                product.setQuantity(resultSet.getString("quantity_product"));
                product.setColor(resultSet.getString("color_product"));
                product.setDescription(resultSet.getString("description_product"));
                product.setIdCategory(resultSet.getInt("id_category"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
