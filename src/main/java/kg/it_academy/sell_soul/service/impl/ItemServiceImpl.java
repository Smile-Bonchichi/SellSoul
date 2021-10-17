package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.repository.ItemRepository;
import kg.it_academy.sell_soul.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item deleteById(Long id) {
        Item itemForDelete = findById(id);
        if (itemForDelete != null)
            itemRepository.deleteById(id);
        return itemForDelete;
    }
}
