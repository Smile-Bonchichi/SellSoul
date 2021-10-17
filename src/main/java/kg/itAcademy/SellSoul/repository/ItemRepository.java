package kg.itAcademy.SellSoul.repository;

import kg.itAcademy.SellSoul.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Long, Item> {
}
