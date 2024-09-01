package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDTO> getAll();

    Optional<List<ProductDTO>> getByCategory(Long id);

    Optional<List<ProductDTO>> getLimitedProducts(Long id);

    Optional<ProductDTO> getProduct(Long id);

    ProductDTO save(ProductDTO productDTO);

    void delete(Long id);
}
