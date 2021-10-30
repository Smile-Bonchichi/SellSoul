package kg.it_academy.sell_soul.entity;

import kg.it_academy.sell_soul.entity.base_entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "images")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Image extends BaseEntity {
    @Column(name = "url")
    private String url;
}
