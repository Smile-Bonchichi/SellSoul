package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, Long> {
}
