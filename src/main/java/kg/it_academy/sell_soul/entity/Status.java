package kg.it_academy.sell_soul.entity;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "statuses")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Status extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}