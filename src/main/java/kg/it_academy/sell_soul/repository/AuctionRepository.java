package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Auction;
import kg.it_academy.sell_soul.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
   @Query(value = "SELECT * from Auction a WHERE a.status = 0", nativeQuery = true)
   List<Auction> getAuctionByActiveStatus();
}
