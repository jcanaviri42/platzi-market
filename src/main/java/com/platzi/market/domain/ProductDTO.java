package com.platzi.market.domain;

public record ProductDTO(
        Long id,
        String name,
//        Long categoryId,
//        CategoryDTO categoryDTO,
        Double salePrice,
        Integer stock,
        Boolean status
) {
}
