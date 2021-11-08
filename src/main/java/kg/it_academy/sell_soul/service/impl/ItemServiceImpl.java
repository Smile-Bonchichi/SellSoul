package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.repository.ItemRepository;
import kg.it_academy.sell_soul.service.ItemService;
import kg.it_academy.sell_soul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;

    @Override
    public Item save(Item item) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByUserLogin(principal.getName());
        item.setUser(user);
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
    public List<Item> findByCategory(String categoryName) {
        return itemRepository.findAllByCategory(categoryName);
    }

    @Override
    public List<Item> findByName(String itemName) {
        return itemRepository.findAllByItemName(itemName);
    }

    @Override
    public List<Item> findByUnActiveItem() {
        return itemRepository.findAllByUnActiveItem();
    }

    @Override
    public List<Item> findByActiveItem() {
        return itemRepository.findAllByActiveItem();
    }

    @Override
    public Item deleteById(Long id) {
        Item itemForDelete = findById(id);
        if (itemForDelete != null)
            itemRepository.deleteById(id);
        return itemForDelete;
    }
}
