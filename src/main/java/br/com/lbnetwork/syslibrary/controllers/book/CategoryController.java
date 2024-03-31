package br.com.lbnetwork.syslibrary.controllers.book;

import br.com.lbnetwork.syslibrary.dtos.book.CategoryRecordDto;
import br.com.lbnetwork.syslibrary.models.book.CategoryModel;
import br.com.lbnetwork.syslibrary.repositories.book.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/category")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody @Valid CategoryRecordDto categoryRecordDto){
        var categoryModelOptional = categoryRepository.findByName(categoryRecordDto.name());
        if (categoryModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(categoryModelOptional.get());
        }
        var categoryModel = new CategoryModel();
        BeanUtils.copyProperties(categoryRecordDto, categoryModel);
        categoryModel.setName(categoryModel.getName().toUpperCase());
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(categoryModel));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable(value = "id")UUID id){
        Optional<CategoryModel> categoryObject = categoryRepository.findById(id);
        if (categoryObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category located in the database checks the UUID provided in the request.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryObject.get());
    }

    @PutMapping("/category/{id}")
    public ResponseEntity updateCategory(@PathVariable(value = "id")UUID id,
                                         @RequestBody @Valid CategoryRecordDto categoryRecordDto){
        Optional<CategoryModel> categoryObject = categoryRepository.findById(id);
        if (categoryObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category located in the database checks the UUID provided in the request.");
        }
        var categoryModel = categoryObject.get();
        var data = categoryObject.get().getUpdatedAt();
        BeanUtils.copyProperties(categoryRecordDto, categoryModel);
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(data);
        categoryModel.setName(categoryRecordDto.name().toUpperCase());
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(categoryModel));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id){
        Optional<CategoryModel> categoryObject = categoryRepository.findById(id);
        if (categoryObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No category located in the database checks the UUID provided in the request.");
        }
        categoryRepository.delete(categoryObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Category successfully deleted from the database.");
    }
}
