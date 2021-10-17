package kg.it_academy.sell_soul.entity;

import javax.persistence.*;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

@Table(name = "baskets")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Basket extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id", unique = true)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}