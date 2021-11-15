package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.converter.UserConverter;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.model.UserAuthModel;
import kg.it_academy.sell_soul.repository.UserRepository;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserAuthModel userAuthModel) {
        UserConverter userConverter = new UserConverter();
        User user = userConverter.convertFromModel(userAuthModel);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return null;
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

    @Override
    public User getByUserLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }

    @Override
    public String getByUserAuthModel(UserAuthModel userAuthModel) {
        User user = userRepository.findByLogin(userAuthModel.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("Неверный логин или пароль"));
        boolean isPasswordCorrect = passwordEncoder.matches(userAuthModel.getPassword(), user.getPassword());
        if (!isPasswordCorrect)
            throw new IllegalArgumentException("Неверный логин или пароль");

        String userPasswordLoginPair = userAuthModel.getLogin() + ":" + userAuthModel.getPassword();
        return "Basic " + new String(Base64.getEncoder().encode(userPasswordLoginPair.getBytes()));
    }
}
