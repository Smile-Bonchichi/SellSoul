package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query(value = "SELECT * from Auction a WHERE a.status = 0", nativeQuery = true)
    List<Auction> getAuctionByActiveStatus();
}
