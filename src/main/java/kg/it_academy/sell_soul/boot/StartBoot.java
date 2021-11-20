package kg.it_academy.sell_soul.boot;

import kg.it_academy.sell_soul.entity.Role;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.entity.UsersRoles;
import kg.it_academy.sell_soul.repository.UserRoleRepository;
import kg.it_academy.sell_soul.repository.UsersRolesRepository;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartBoot implements CommandLineRunner {
    private final UserService userService;
    private final UserRoleRepository userRoleRepository;
    private final UsersRolesRepository usersRolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StartBoot(UserService userService, UserRoleRepository userRoleRepository,
                     UsersRolesRepository usersRolesRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleRepository = userRoleRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        UsersRoles usersRoles = new UsersRoles();

        usersRoles.setUser(userService.save(User.builder()
                .login("ADMIN")
                .password(passwordEncoder.encode("ADMIN"))
                .balance(BigDecimal.valueOf(0))
                .isActive(1L)
                .build()));
        usersRoles.setRole(userRoleRepository.save(Role.builder()
                .name("ROLE_ADMIN")
                .build()));
        usersRolesRepository.save(usersRoles);
    }
}
