package kg.itAcademy.SellSoul.repository;

import kg.itAcademy.SellSoul.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Long, Category> {
}
