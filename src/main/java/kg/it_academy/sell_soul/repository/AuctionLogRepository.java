package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.AuctionLog;
import kg.it_academy.sell_soul.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionLogRepository extends JpaRepository<AuctionLog, Long> {
    List<AuctionLog> findAuctionLogsByAuction_Id(Long id);
}
