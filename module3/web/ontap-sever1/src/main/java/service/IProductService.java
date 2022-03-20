package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();

    void addNew(Product product);

    Map<String, String> checkValidate(Product product);

    Product findById(int id);

    void delete(int id);

    List<Product> search(String name);

    List<Product> searchPrice(double price);

}
