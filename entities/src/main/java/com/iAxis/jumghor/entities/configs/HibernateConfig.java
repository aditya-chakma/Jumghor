package com.iAxis.jumghor.entities.configs;

import com.iAxis.jumghor.entities.interceptor.PersistentInterceptor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025 10:26 AM
 */
@Configuration
public class HibernateConfig implements HibernatePropertiesCustomizer {

    @Bean
    public PersistentInterceptor persistentInterceptor() {
        return new PersistentInterceptor();
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        //hibernateProperties.put(AvailableSettings.INTERCEPTOR, PersistentInterceptor.class);
    }

}
