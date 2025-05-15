package com.iAxis.jumghor.entities.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Configuration
@EnableJpaAuditing // jpa auditing needed for id generation
public class SpringConfig {
}
