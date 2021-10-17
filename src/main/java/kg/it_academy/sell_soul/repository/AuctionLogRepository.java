package kg.it_academy.sell_soul.repository;

import kg.it_academy.sell_soul.entity.AuctionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionLogRepository extends JpaRepository<Long, AuctionLog> {
}
