package kg.it_academy.sell_soul.contoller.base_controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public abstract class BaseController<T> {

    @PostMapping
    public abstract T save(@RequestBody T t);

    @GetMapping
    public abstract List<T> getAll();

    @GetMapping("/{id}")
    public abstract T findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    public abstract T deleteById(@PathVariable Long id);
}
