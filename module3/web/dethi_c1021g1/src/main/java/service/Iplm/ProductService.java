package service.Iplm;

import model.Product;
import repository.ICategoryRepository;

import repository.IProductRepository;
import repository.Iplm.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository=  new ProductRepository();
    @Override
    public List<Product> findAll() {
        List<Product> productList=iProductRepository.findAll();
        if (productList.size() == 0) {
            return null;
        }else {
            return productList ;
        }
    }

    @Override
    public void addNew(Product product) {
        iProductRepository.addNew(product);
    }

    @Override
    public Product findById(int id) {
      return   iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
