package services;


import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServices implements IProductServices {
    private static final Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "IPHONEX", 100000L, "Hanoi", "Apple"));
        productList.put(2, new Product(2, "SAMSUNG", 5000000L, "Danang", "TOKIO"));
        productList.put(3, new Product(3, "HAWAI", 200000L, "Saigon", "VIET NAM"));
        productList.put(4, new Product(4, "MOBIE", 300000L, "Beijin", "VIET NAM"));
        productList.put(5, new Product(5, "OPPO", 54201100L, "Miami", "VIET NAM"));
        productList.put(6, new Product(6, "ASUS", 300000L, "Newyork", "VIET NAM"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer,Product> entry : productList.entrySet()) {
            if(entry.getValue().getName().contains(name)){
                products.add(entry.getValue());
            }
        }
        return products;
    }
}
