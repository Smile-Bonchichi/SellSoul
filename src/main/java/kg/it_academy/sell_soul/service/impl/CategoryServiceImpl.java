package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Category;
import kg.it_academy.sell_soul.repository.CategoryRepository;
import kg.it_academy.sell_soul.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category deleteById(Long id) {
        Category categoryForDelete = findById(id);
        if (categoryForDelete != null)
            categoryRepository.deleteById(id);
        return categoryForDelete;
    }
}
