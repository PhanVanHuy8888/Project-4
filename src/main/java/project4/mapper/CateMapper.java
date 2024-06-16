package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import project4.dto.request.CategoryRequest;
import project4.dto.response.CategoryResponse;
import project4.entity.Category;

@Mapper(componentModel = "spring")
public interface CateMapper {

    Category createCate(CategoryRequest request);

    CategoryResponse toCate(Category category);

    void updateCate(@MappingTarget Category category, CategoryRequest request);

}
