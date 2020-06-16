package com.github.hotire.spring.utils.base.ex;

import com.github.hotire.spring.utils.base.Entity;
import com.github.hotire.spring.utils.base.EntityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements EntityService {

    @Override
    public Entity find(final Long id) {
        return new Account(1L);
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
