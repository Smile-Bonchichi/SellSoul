package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.repository.UserRepository;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User deleteById(Long id) {
        User userForDelete = findById(id);
        if (userForDelete != null)
            userRepository.deleteById(id);
        return userForDelete;
    }
}
