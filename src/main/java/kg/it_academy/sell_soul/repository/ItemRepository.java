package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Long, Item> {
}
