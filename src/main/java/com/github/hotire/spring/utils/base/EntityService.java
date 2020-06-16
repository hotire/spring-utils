package com.github.hotire.spring.utils.base;

import java.util.List;
import java.util.Optional;

public interface EntityService {
    Optional<Entity> find(final Long id);
    List<Entity> findAll();
    Entity save(final Entity entity);
}
