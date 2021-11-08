package kg.it_academy.sell_soul.entity;

import javax.persistence.*;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "auctions")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Auction extends BaseEntity {
    @Column(name = "add_time")
    private LocalDateTime addTime;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "start_price")
    private BigDecimal startPrice;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
}