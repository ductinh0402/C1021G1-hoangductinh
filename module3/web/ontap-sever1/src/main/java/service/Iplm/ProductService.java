package service.Iplm;

import jdk.nashorn.internal.ir.SplitReturn;
import model.Product;
import repository.IProductRepository;
import repository.Iplm.ProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

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
    public Map<String, String> checkValidate(Product product) {
        Map<String, String> productMap = new HashMap<>();
        if (!(product.getNameProduct().matches("([A-Za-z])\\w+"))) {
            productMap.put("name", "Bạn không được để trống và phải nhập chữ");
        }
        if (product.getPrice() < 10000000) {
            productMap.put("price", "Nhập trên chục triệu");
        }
        if (!(product.getQuantity() > 0)) {
            productMap.put("quantity", "Phải là số dương và không được để trống.");
        }
        return productMap;
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = iProductRepository.search(name);
        if (productList.size()==0){
            return null;
        }else {
            return productList;
        }
    }

    @Override
    public List<Product> searchPrice(double price) {
        List<Product> productList = iProductRepository.searchPrice(price);
        if (productList.size()==0){
            return null;
        }else {
            return productList;
        }
    }
}
