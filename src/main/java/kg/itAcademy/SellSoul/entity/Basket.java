package kg.itAcademy.SellSoul.entity;

import javax.persistence.*;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;

@Table(name = "baskets")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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