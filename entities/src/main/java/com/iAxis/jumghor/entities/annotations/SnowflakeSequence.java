package com.iAxis.jumghor.entities.annotations;

import com.iAxis.jumghor.entities.configs.SnowflakeGenerator;
import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025 4:21 PM
 */
@IdGeneratorType(SnowflakeGenerator.class)
@Retention(RUNTIME)
@Target({METHOD, FIELD})
public @interface SnowflakeSequence {
}