package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.Basket;
import kg.it_academy.sell_soul.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController extends BaseController<Basket> {
    @Autowired
    private BasketService basketService;

    @PostMapping
    @Override
    public Basket save(@RequestBody Basket basket) {
        return basketService.save(basket);
    }

    @GetMapping
    @Override
    public List<Basket> getAll() {
        return basketService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public Basket findById(@PathVariable Long id) {
        return basketService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public Basket deleteById(@PathVariable Long id) {
        return basketService.deleteById(id);
    }
}
