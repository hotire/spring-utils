package com.github.hotire.spring.utils.base;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void getId() {
        // given
        final Entity entity = new Entity();

        // when
        final Long result = entity.getId();

        // then
        Assertions.assertThat(result).isNotNull();
    }
}