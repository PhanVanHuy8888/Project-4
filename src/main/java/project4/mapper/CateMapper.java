package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import project4.dto.request.CategoryRequest;
import project4.dto.response.CategoryResponse;
import project4.entity.Category;
import project4.repository.CategoryRepo;

@Mapper(componentModel = "spring")
public interface CateMapper {

    @Autowired
    public CategoryRepo cateRepo = null;

    @Named("categoryIdToCategoryName")
    public static String categoryIdToCategoryName(int categoryId) {
        return cateRepo.findNameById(categoryId);
    }

    Category createCate(CategoryRequest request);

    CategoryResponse toCate(Category category);

    void updateCate(@MappingTarget Category category, CategoryRequest request);

}
