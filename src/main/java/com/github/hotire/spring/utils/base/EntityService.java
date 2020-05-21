package com.github.hotire.spring.utils.base;

import java.util.List;

public interface EntityService {
    Entity find(final Long id);
    List<Entity> findAll();
}
