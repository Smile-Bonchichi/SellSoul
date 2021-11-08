package kg.it_academy.sell_soul.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

@Table(name = "categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Category extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}