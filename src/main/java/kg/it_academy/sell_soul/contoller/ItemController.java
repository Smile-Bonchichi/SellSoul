package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController extends BaseController<Item> {
    @Autowired
    private ItemService itemService;

    @PostMapping
    @Override
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping
    @Override
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Item findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/search-item/{itemName}")
    public List<Item> findByItemName(@PathVariable String itemName) {
        return itemService.findByName(itemName);
    }

    @GetMapping("/{categoryName}")
    public List<Item> findByCategoryName(@PathVariable String categoryName) {
        return itemService.findByCategory(categoryName);
    }

    @GetMapping("/un-active-item")
    public List<Item> findByUnActiveItem() {
        return itemService.findByUnActiveItem();
    }

    @GetMapping("/active-item")
    public List<Item> findByActiveItem() {
        return itemService.findByActiveItem();
    }

    @DeleteMapping("/{id}")
    @Override
    public Item deleteById(@PathVariable Long id) {
        return itemService.deleteById(id);
    }
}
