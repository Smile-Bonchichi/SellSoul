package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.converter.UserConverter;
import kg.it_academy.sell_soul.entity.Role;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.entity.UsersRoles;
import kg.it_academy.sell_soul.model.UserAuthModel;
import kg.it_academy.sell_soul.repository.UserRepository;
import kg.it_academy.sell_soul.repository.UserRoleRepository;
import kg.it_academy.sell_soul.repository.UsersRolesRepository;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final UsersRolesRepository usersRolesRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UsersRolesRepository usersRolesRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.usersRolesRepository = usersRolesRepository;
    }

    @Override
    public User save(UserAuthModel userAuthModel) {
        User user = new UserConverter().convertFromModel(userAuthModel);
        UsersRoles usersRoles = new UsersRoles();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsActive(1L);

        usersRoles.setUser(user);
        usersRoles.setRole(userRoleRepository.save(Role.builder()
                .name("ROLE_USER")
                .build()));

        usersRolesRepository.save(usersRoles);

        return userRepository.save(user);
    }

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
