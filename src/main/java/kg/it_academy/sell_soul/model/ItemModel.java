package kg.it_academy.sell_soul.model;

import kg.it_academy.sell_soul.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ItemModel {

    private String name;

    private String imageUrl;

    private String description;

    private Category category;
}
