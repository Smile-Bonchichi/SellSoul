package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.entity.Category;
import kg.it_academy.sell_soul.model.ResponseMessage;
import kg.it_academy.sell_soul.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseMessage<Category> save(@RequestBody Category category) {
        return new ResponseMessage<Category>().prepareSuccessMessage(categoryService.save(category));
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseMessage<Category> findById(@PathVariable Long id) {
        return new ResponseMessage<Category>().prepareSuccessMessage(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Category> deleteById(@PathVariable Long id) {
        return new ResponseMessage<Category>().prepareSuccessMessage(categoryService.deleteById(id));
    }
}
