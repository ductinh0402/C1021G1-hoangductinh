package repository.Imlp;

import model.Product;
import repository.IProductRepository;


import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList =new ArrayList<>();
    static {
        productList.add(new Product(1,"Kẹo",20000,"Ngon,thơm,bay bỏng,...","Phố trong làng"));
        productList.add(new Product(2,"Ke",30000,"Ngọt ngào,baylak,...","Làng trong phố"));
        productList.add(new Product(3,"Dầu thơm",40000,"Hôi,nồng say,...","Trong Làng phố"));
        productList.add(new Product(4,"Shisa",50000,"Nóng,khói hình trái tim,....","Vinahouse"));
        productList.add(new Product(5,"Bóng bay",18000,"Ngậm sưng miệng,...","Kingclub"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product){
        for (Product temp : productList) {
            if (temp.getId()== product.getId()){
                temp.setName(product.getName());
                temp.setPrice(product.getPrice());
                temp.setDescription(product.getDescription());
                temp.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void remove(int id) {
//        for (Product productManagement : productList) {
//            if (productManagement.getId()==id){
//                productList.remove(id - 1);
//            }
//        }
        productList.remove(id -1);

    }

    @Override
    public List<Product> search(String name) {
        List<Product> productArrayList=new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)){
               productArrayList.add(product);
            }
        }
        return productArrayList;
    }


}
