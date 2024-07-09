package project4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project4.dto.request.ProductRequest;
import project4.dto.response.ProductResponse;
import project4.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestPart("product") ProductRequest request,
                                         @RequestPart("image") MultipartFile image) {
        return productService.createProduct(request, image);
    }



    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable int id, @RequestPart("product") ProductRequest request,
                                         @RequestPart("image") MultipartFile image) {
        return productService.updateProduct(id, request, image);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product has been deleted";
    }

    @GetMapping("/search/{name}")
    public List<ProductResponse> searchProduct(@PathVariable String name){
        return productService.searchProduct(name);
    }
}
