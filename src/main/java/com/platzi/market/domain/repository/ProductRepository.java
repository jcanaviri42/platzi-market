package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public interface ProductRepository {

    List<ProductDTO> getAll();
    
    Optional<List<ProductDTO>> getByCategory(Long id);
    
    Optional<List<ProductDTO>> getLimitedProducts(int quantity);
    
    Optional<ProductDTO> getProduct(Long id);
    
    ProductDTO save(Product product);
    
    void delete(Long id);

}
