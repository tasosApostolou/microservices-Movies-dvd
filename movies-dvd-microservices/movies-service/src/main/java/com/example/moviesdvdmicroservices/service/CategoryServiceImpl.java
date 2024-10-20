package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityAlreadyExistsException;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.mapper.Mapper;
import com.example.moviesdvdmicroservices.model.Category;
import com.example.moviesdvdmicroservices.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;  //injected as autowired by annotation @RequiredArgsConstructor
    @Override
    @Transactional
    public Category insert(CategoryInsertDTO dto) throws Exception {
        Category category;
        try {
            category = Mapper.mapToCategory(dto);
            Optional<Category> categoryToCreate = categoryRepository.findDistinctFirstByCategoryName(category.getCategoryName());
            if (categoryToCreate.isPresent()) throw new EntityAlreadyExistsException(Category.class,dto.getCategoryName());
            category = categoryRepository.save(category);
            if(category.getId()==null){
                throw new Exception("Insert error");
            }
            log.info("insert succes for category with id"+ category.getId());
            return category;
        } catch (EntityAlreadyExistsException e) {
            log.error("insert error " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) throws EntityNotFoundException {
        Category category;
        try {
            category = categoryRepository.findDistinctFirstByCategoryName(categoryName).orElseThrow(() -> new EntityNotFoundException(Category.class,0L));
//            if (directors.isEmpty()) throw new EntityNotFoundException(Director.class,0L);
            log.info("Category with title  "+ categoryName +" was found");
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return category;    }

    @Override
    public Category getCategoryById(Long id) throws EntityNotFoundException {
        Category category;
        try {
//                category = categoryRepository.findCategoryById(id);
//                if(category==null)throw new EntityNotFoundException(Category.class,id);
            category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Category.class,id));
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return category;
    }
}
