package kg.it_academy.sell_soul.contoller;

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
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseMessage<User> save(@RequestBody User user) {
        return new ResponseMessage<User>().prepareSuccessMessage(userService.save(user));
    }

    @PostMapping("/sign-in")
    public ResponseMessage<String> signIn(@RequestBody UserAuthModel userAuthModel) {
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        try {
            return responseMessage.prepareSuccessMessage(userService.getByUserAuthModel(userAuthModel));
        } catch (IllegalArgumentException e) {
            return responseMessage.prepareSuccessMessage(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseMessage<User> findById(@PathVariable Long id) {
        return new ResponseMessage<User>().prepareSuccessMessage(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<User> deleteById(@PathVariable Long id) {
        return new ResponseMessage<User>().prepareSuccessMessage(userService.deleteById(id));
    }
}
