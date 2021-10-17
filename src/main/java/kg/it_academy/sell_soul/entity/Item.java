package kg.it_academy.sell_soul.entity;

import javax.persistence.*;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

@Table(name = "items")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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