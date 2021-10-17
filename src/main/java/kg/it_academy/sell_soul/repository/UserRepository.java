package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User, Long> {
}
