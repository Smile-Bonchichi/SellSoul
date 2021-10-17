package kg.it_academy.sell_soul.contoller.base_controller;

import java.util.List;

public interface BaseController<T> {
    T save(T t);

    List<T> getAll();

    T findById(Long id);

    T deleteById(Long id);
}
