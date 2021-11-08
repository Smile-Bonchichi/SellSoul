package kg.it_academy.sell_soul.service;

import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.service.base_service.BaseService;

import java.util.List;

public interface ItemService extends BaseService<Item> {
    List<Item> findByCategory(String categoryName);

    List<Item> findByName(String itemName);

    List<Item> findByUnActiveItem();

    List<Item> findByActiveItem();
}
