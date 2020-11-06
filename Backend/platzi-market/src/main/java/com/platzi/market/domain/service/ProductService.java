package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository _produRepository;

    public List<Product> getAll(){
        return _produRepository.getAll();
    };

    public Optional<Product> getProduct(int productId){
        return _produRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return _produRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return _produRepository.save(product);
    }
    public boolean delete(int productId){

        return  getProduct(productId).map(product -> {
            _produRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
