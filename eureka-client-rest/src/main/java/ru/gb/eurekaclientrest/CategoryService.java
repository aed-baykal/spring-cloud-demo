package ru.gb.eurekaclientrest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getAllTitles() {
        return categoryRepository.findAll().stream().map(Category::getTitle).collect(Collectors.toList());
    }
}
