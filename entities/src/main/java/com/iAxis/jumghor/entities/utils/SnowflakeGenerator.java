package com.iAxis.jumghor.entities.utils;

import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.springframework.beans.factory.annotation.Value;

import java.util.EnumSet;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025 4:16 PM
 */
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
