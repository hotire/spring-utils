package com.github.hotire.spring.utils.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public abstract class EntityController<T extends Entity> {

    protected abstract EntityService getService();

    @GetMapping
    public List<Entity> list() {
        return getService().findAll();
    }

    @GetMapping("/{id}")
    public Entity get(@PathVariable Long id) {
        return getService().find(id);
    }
}
