package kg.itAcademy.SellSoul.repository;

import kg.itAcademy.SellSoul.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
