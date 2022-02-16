package ru.gb.eurekaclientrest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.modelapi.ProductDto;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Mapping(source = "category.title", target = "category")
    public abstract ProductDto productToProductDto(Product product);

    @Named("titleToCategory")
    public Category categoryTitleToCategory(String categoryTitle) {
        return categoryRepository.findByTitle(categoryTitle).orElse(null);
    }

    @Mapping(source = "category", target = "category", qualifiedByName = "titleToCategory")
    public abstract Product productDtoToProduct(ProductDto productDto);
}
