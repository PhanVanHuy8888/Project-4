package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.dto.request.CategoryRequest;

import project4.dto.response.CategoryResponse;
import project4.entity.Category;
import project4.mapper.CateMapper;
import project4.repository.CategoryRepo;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo cateRepo;

    private final CateMapper cateMapper;

    public CategoryResponse createCate(CategoryRequest request) {
//        if(cateRepo.findByName(request.getName())) throw new RuntimeException("Catename already exist");

        Category category = cateMapper.createCate(request);
        category.setCreateDate(new Date());

        return cateMapper.toCate(cateRepo.save(category));
    }

    public CategoryResponse updateCate(int id, CategoryRequest request){
           Category category = cateRepo.findById(id).orElseThrow(() -> new RuntimeException("category not found"));

           cateMapper.updateCate(category, request);
           category.setUpdateDate(new Date());

           return cateMapper.toCate(cateRepo.save(category));
    }

    public List<CategoryResponse> getAll() {
        return cateRepo.findAll().stream().map(cateMapper::toCate).toList();
    }

    public CategoryResponse getCateById(int id){
        Category cate = cateRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found cate"));
        return cateMapper.toCate(cate);
    }

    public void deleteCate(int id){
        cateRepo.deleteById(id);
    }
}
