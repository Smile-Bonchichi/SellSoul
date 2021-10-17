package kg.it_academy.sell_soul.service.impl;

import kg.it_academy.sell_soul.entity.Basket;
import kg.it_academy.sell_soul.repository.BasketRepository;
import kg.it_academy.sell_soul.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public Basket findById(Long id) {
        return basketRepository.findById(id).orElse(null);
    }

    @Override
    public Basket deleteById(Long id) {
        Basket basketForDelete = findById(id);
        if (basketForDelete != null)
            basketRepository.deleteById(id);
        return basketForDelete;
    }
}
