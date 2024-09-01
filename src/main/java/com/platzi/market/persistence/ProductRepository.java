package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getByCategoryId(Long id) {
        return productRepository.findByCategoryIdOrderByNameAsc(id);
    }

    public Optional<List<Product>> getLimited(int quantity) {
        return productRepository.findByStockLessThanAndStatus(quantity, true);
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
