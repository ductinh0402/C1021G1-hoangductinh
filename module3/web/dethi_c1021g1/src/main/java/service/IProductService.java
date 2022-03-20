package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void addNew(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> search(String name);
}
