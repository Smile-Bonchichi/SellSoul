package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @PostMapping
    @Override
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public User deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
