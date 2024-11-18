package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(Long id) {
        return this.productRepository.getProduct(id);
    }

    public Optional<List<ProductDTO>> getByCategory(Long id) {
        return this.productRepository.getByCategory(id);
    }

    public ProductDTO save(Product product) {
        return this.productRepository.save(product);
    }

    public boolean delete(Long id) {
        return getProduct(id).map(p -> {
            this.productRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
