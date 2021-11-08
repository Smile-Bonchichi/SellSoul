package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM items t WHERE t.name LIKE %:itemName%", nativeQuery = true)
    List<Item> findAllByItemName(@Param("itemName") String itemName);

    @Query(value = "SELECT * FROM items t JOIN categories c ON c.id = t.category_id WHERE c.name = :category", nativeQuery = true)
    List<Item> findAllByCategory(@Param("category") String category);

    @Query(value = "SELECT * FROM items t JOIN auctions au ON au.item_id = t.id WHERE now() BETWEEN au.add_time and au.start_time", nativeQuery = true)
    List<Item> findAllByUnActiveItem();

    @Query(value = "SELECT * FROM items t JOIN auctions au ON au.item_id = t.id WHERE now() BETWEEN au.start_time and au.end_time", nativeQuery = true)
    List<Item> findAllByActiveItem();
}
