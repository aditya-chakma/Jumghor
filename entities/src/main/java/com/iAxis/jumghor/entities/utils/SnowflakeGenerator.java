package com.iAxis.jumghor.entities.utils;

import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025 4:16 PM
 */
/*
 * This ID generator generates id for DB entities
 * The `@Component` annotation is nedded. Without this, Spring won't inject the
 * `@Value("${server.id}")`. It generally works without the annotation when all properties are
 * inside `application.properties` files. But, if we use a separate config-server, we must use
 * the component for spring injection. Otherwise, this would be a hibernate bean and the value will always be null.
 * - Aditya
 * */
@Component
public class SnowflakeGenerator implements BeforeExecutionGenerator {

    @Value("${server.id}")
    private Integer serverId;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue, EventType eventType) {
        return RandomGenerator.init().randomUUID(serverId);
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }
}
