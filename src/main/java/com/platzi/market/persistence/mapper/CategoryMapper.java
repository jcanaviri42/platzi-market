package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.CategoryDTO;
import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@SuppressWarnings("unused")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "status")
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    Category toCategory(CategoryDTO categoryDTO);

}
