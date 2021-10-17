package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Long, Auction> {
}
