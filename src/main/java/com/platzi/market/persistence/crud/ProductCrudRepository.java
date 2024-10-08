package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategoryIdOrderByNameAsc(Long id);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);

}
