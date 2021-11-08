package kg.it_academy.sell_soul.contoller;

import kg.it_academy.sell_soul.contoller.base_controller.BaseController;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.model.UserAuthModel;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kg.it_academy.sell_soul.model.ResponseMessage;

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

    @PostMapping("/sign-in")
    public ResponseMessage<String> save(@RequestBody UserAuthModel userAuthModel) {
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        try {
            String authHeader = userService.getByUserAuthModel(userAuthModel);
            return responseMessage.prepareSuccessMessage(authHeader);
        } catch (IllegalArgumentException e) {
            return responseMessage.prepareSuccessMessage(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        }
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
