package service;

import model.Product;
import repository.IProductRepository;
import repository.Imlp.ProductRepository;

import java.util.List;

public class ProductService implements  IProductService{
    IProductRepository iProductRepository=new ProductRepository();

    @Override
    public void save(Product product) {
          iProductRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
      List<Product> productList = iProductRepository.findAll();
      if (productList.size()==0){
          return null;
      }else {
          return iProductRepository.findAll();
      }
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
     return    iProductRepository.search(name);
    }


}
