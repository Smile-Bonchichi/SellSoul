package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.entity.User;
import kg.it_academy.sell_soul.exception.ApiFailException;
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
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

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
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null)
            throw new ApiFailException("Не найден товар с таким id!");
        return item;
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
        else
            throw new ApiFailException("Товар с таким id не найден!");
        return itemForDelete;
    }
}
