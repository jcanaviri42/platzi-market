package com.platzi.market.persistence;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@SuppressWarnings("unused")
public class ProductRepository implements com.platzi.market.domain.repository.ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return this.mapper.toProductDTOList(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(Long id) {
        List<Product> products = this.productCrudRepository.findByCategoryIdOrderByNameAsc(id);
        return Optional.of(this.mapper.toProductDTOList(products));
    }

    @Override
    public Optional<List<ProductDTO>> getLimitedProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository
                .findByStockLessThanAndStatus(quantity, true);

        return products.map(prod -> Collections.singletonList(
                mapper.toProductDTO((Product) prod)));
    }

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return this.productCrudRepository.findById(id)
                .map(prod -> this.mapper.toProductDTO(prod));
    }

    public List<Product> getByCategoryId(Long id) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(id);
    }

    public Optional<List<Product>> getLimited(int quantity) {
        return productCrudRepository.findByStockLessThanAndStatus(quantity, true);
    }

    @Override
    public ProductDTO save(Product product) {

        ProductDTO productDTO = this.mapper.toProductDTO(product);
        return this.mapper.toProductDTO(this.productCrudRepository.save(product));
    }

    public void delete(Long id) {
        productCrudRepository.deleteById(id);
    }

}
