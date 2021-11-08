package kg.it_academy.sell_soul.entity;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "auction_logs")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuctionLog extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "highest_price")
    private BigDecimal highestPrice;
}
