package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.AuctionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionLogRepository extends JpaRepository<AuctionLog, Long> {
    List<AuctionLog> findAuctionLogsByAuction_Id(Long id);
}
