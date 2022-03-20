package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product) ;


    List<Product> findAll();


    Product findById(int id);

    void update(Product product);


    void remove(int id);

    List<Product> search(String name);
}
