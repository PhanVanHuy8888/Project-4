package project4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project4.dto.request.ProductRequest;
import project4.dto.response.ProductResponse;
import project4.entity.Product;
import project4.mapper.ProductMapper;
import project4.repository.CategoryRepo;
import project4.repository.ProductRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    private final String uploadDir = "src/main/resources/static/img";

    @Autowired
    private ProductMapper productMapper;

    public ProductService() {
        File uploadDirFile = new File(uploadDir);
        if(!uploadDirFile.exists()){
            uploadDirFile.mkdirs();
        }
    }

    public ProductResponse createProduct(ProductRequest request, MultipartFile image) {
        Product product = productMapper.createProduct(request);
        product.setCreateDate(new Date());

        int categoryId = categoryRepo.findIdByName(request.getCategoryName());
        product.setCategoryId(categoryId);

        if (image != null && !image.isEmpty()) {
            try {
                String imageUrl = saveImage(image);
                product.setImage(imageUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productMapper.toProduct(productRepo.save(product));
    }


    public ProductResponse updateProduct(int id, ProductRequest request, MultipartFile image) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        productMapper.updateProduct(product, request);
        product.setUpdateDate(new Date());

        int categoryId = categoryRepo.findIdByName(request.getCategoryName());
        product.setCategoryId(categoryId);

        if (image != null && !image.isEmpty()) {
            try {
                String imageUrl = saveImage(image);
                product.setImage(imageUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productMapper.toProduct(productRepo.save(product));
    }

    public ProductResponse getById(int id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<ProductResponse> getAll() {
        return productRepo.findAll().stream().map(productMapper::toProduct).toList();

    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }

    private String saveImage(MultipartFile image) throws IOException {
        String uniqueFileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, uniqueFileName);
        Files.copy(image.getInputStream(), filePath);
        System.out.println(filePath.toString());
        return uniqueFileName;
    }

}
