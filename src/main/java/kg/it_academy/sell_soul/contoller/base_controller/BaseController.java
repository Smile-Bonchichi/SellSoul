package kg.it_academy.sell_soul.contoller.base_controller;

import java.util.List;

public abstract class BaseController<T> {

    public abstract T save(T t);

    public abstract List<T> getAll();

    public abstract T findById(Long id);

    public abstract T deleteById(Long id);
}
