package com.iAxis.jumghor.entities.configs;

import com.iAxis.jumghor.entities.interceptor.PersistentInterceptor;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025 10:26 AM
 */
@Configuration
public class HibernateConfig implements HibernatePropertiesCustomizer {

    private PersistentInterceptor persistentInterceptor;

    public HibernateConfig(@Autowired PersistentInterceptor persistentInterceptor) {
        this.persistentInterceptor = persistentInterceptor;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        System.out.println("\n\n\n\n\nRegistering interceptor!\n\n\n\n\n");
        hibernateProperties.put(AvailableSettings.INTERCEPTOR, persistentInterceptor);
    }
}
