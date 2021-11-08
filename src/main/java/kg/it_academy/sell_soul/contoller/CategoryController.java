package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.Category;
import kg.it_academy.sell_soul.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @Override
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping
    @Override
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public Category deleteById(@PathVariable Long id) {
        return categoryService.deleteById(id);
    }
}
