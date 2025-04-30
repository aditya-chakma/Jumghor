package com.iAxis.jumghor.entities.interceptor;

import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static com.iAxis.jumghor.entities.utils.EntityUtils.isValidIdentifier;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Component
public class PersistentInterceptor implements Interceptor, Serializable {

    @Override
    public boolean onPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        System.out.println("\n\n\n\n\nTriggering pre persist\n\n\n\n\n");

        if (Persistent.class.isAssignableFrom(entity.getClass())) {
            Persistent instance = (Persistent) entity;

            if (!isValidIdentifier(instance.getId())) {
                instance.setId(RandomGenerator.init().randomUUID());
                return true;
            }
        }

        return false;
    }


}
