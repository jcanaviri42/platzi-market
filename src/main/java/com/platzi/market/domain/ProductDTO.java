package com.platzi.market.domain;

public record ProductDTO(
        Long id,
        String name,
        Long categoryId,
        Double salePrice,
        Integer stock,
        Boolean status,
        CategoryDTO categoryDTO) {
}
