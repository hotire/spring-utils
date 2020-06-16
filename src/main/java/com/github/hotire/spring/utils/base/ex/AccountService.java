package com.github.hotire.spring.utils.base.ex;

import com.github.hotire.spring.utils.base.Entity;
import com.github.hotire.spring.utils.base.EntityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements EntityService {

    @Override
    public Optional<Entity> find(final Long id) {
        return Optional.ofNullable(new Account(1L));
    }

    @Override
    public List<Entity> findAll() {
        final ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new Account(1L));
        return entities;
    }

    @Override
    public Entity save(Entity entity) {
        return entity;
    }
}
