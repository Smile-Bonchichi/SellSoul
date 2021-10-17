package kg.itAcademy.SellSoul.entity;

import javax.persistence.*;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;
import lombok.*;

@Table(name = "items")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Item extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}