package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
@SuppressWarnings("unused")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "salePrice", target = "salePrice"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "status"),
//            @Mapping(source = "category_id", target = "categoryId"),
//            @Mapping(source = "category", target = "categoryDTO")
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOList(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDTO productDTO);

}
