package project4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project4.dto.request.CategoryRequest;
import project4.dto.response.CategoryResponse;
import project4.service.CategoryService;

@RestController
@RequestMapping("/cates")
public class CateController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponse createUser(@RequestBody CategoryRequest request){

        return categoryService.createCate(request);
    }
}
