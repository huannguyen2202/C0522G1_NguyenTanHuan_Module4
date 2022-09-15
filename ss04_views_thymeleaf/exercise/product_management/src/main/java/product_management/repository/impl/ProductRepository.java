package product_management.repository.impl;

import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "TL-027", 4000, "Mau xanh", "Thien Long"));
        products.put(2, new Product(2, "Tay", 4000, "Mau den", "Deli"));
        products.put(3, new Product(3, "but chi", 3000, "Mau vang", "G-start"));
        products.put(4, new Product(4, "vo", 7000, "Mau trang", "Hai Tien"));
        products.put(5, new Product(5, "but mau", 20000, "nhieu mau", "Thien Long"));
        products.put(6, new Product(6, "ghim", 4000, "Mau trang", "Deli"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> iteam : products.entrySet()) {
            if (iteam.getValue().getProductName().contains(name)) {
                productList.add(iteam.getValue());
            }
        }
        return productList;
    }


}
