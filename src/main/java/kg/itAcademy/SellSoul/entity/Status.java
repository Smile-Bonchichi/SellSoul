package kg.itAcademy.SellSoul.entity;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "statuses")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Status extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
}