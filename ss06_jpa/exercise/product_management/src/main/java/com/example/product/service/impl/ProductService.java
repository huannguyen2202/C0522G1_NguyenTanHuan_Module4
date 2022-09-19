package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {

        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.delete(findById(id));
    }

    @Override
    public List<Product> finByName(String name) {
        return iProductRepository.searchByName(name);
    }

}
