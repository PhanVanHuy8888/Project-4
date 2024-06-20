package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project4.dto.request.ProductRequest;
import project4.dto.response.ProductResponse;
import project4.entity.Product;
import project4.repository.CategoryRepo;

@Component
public class ProductMapper  {

    @Autowired
    private CategoryRepo categoryRepo;
    public Product createProduct(ProductRequest request) {
        if (request == null) {
            return null;
        } else {
            Product product = new Product();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());
            product.setQuantity(request.getQuantity());
            product.setIsActive(request.getIsActive());
            return product;
        }
    }

    public ProductResponse toProduct(Product product) {
        if (product == null) {
            return null;
        } else {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setImage(product.getImage());
            productResponse.setPrice(product.getPrice());
            productResponse.setDescription(product.getDescription());
            productResponse.setQuantity(product.getQuantity());
            productResponse.setIsActive(product.getIsActive());

            String cateName = categoryRepo.findNameById(product.getCategoryId());
            productResponse.setCategoryName(cateName);
            return productResponse;
        }
    }

    public void updateProduct(Product product, ProductRequest request) {
        if (request != null) {
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());
            product.setQuantity(request.getQuantity());
            product.setIsActive(request.getIsActive());
        }
    }
}