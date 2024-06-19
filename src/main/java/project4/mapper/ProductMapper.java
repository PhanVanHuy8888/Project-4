package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import project4.dto.request.ProductRequest;
import project4.dto.response.ProductResponse;
import project4.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "image", ignore = true)
    Product createProduct(ProductRequest request);

    ProductResponse toProduct(Product product);

    @Mapping(target = "image", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    void updateProduct(@MappingTarget Product product, ProductRequest request);
}
