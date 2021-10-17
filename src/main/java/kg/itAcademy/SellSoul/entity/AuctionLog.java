package kg.itAcademy.SellSoul.entity;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "auction_logs")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AuctionLog extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "highest_price")
    private Long highestPrice;
}
