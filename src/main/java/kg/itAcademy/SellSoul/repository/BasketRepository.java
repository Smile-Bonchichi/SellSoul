package kg.itAcademy.SellSoul.repository;

import kg.itAcademy.SellSoul.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Long, Basket> {
}
