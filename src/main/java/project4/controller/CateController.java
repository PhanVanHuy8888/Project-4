package project4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project4.dto.request.CategoryRequest;
import project4.dto.response.CategoryResponse;
import project4.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/cate")
@RequiredArgsConstructor
public class CateController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable int id) {
        return categoryService.getCateById(id);
    }

    @PostMapping
    public CategoryResponse createUser(@RequestBody CategoryRequest request){

        return categoryService.createCate(request);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCate(@PathVariable int id, @RequestBody CategoryRequest request) {
        return categoryService.updateCate(id, request);
    }

    @GetMapping("/listCate")
    public List<CategoryResponse>  getAll() {
        return categoryService.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteCate(@PathVariable int id) {
        categoryService.deleteCate(id);
        return "Cate has been deleted";
    }
}
