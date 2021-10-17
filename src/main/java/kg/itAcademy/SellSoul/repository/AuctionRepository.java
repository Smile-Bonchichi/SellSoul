package kg.itAcademy.SellSoul.repository;

import kg.itAcademy.SellSoul.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Long, Auction> {
}
