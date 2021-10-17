package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Long, Category> {
}
