package kg.itAcademy.SellSoul.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;

@Table(name = "categories")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Category extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}