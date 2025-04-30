package com.iAxis.jumghor.entities.intereceptor;

import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.stereotype.Component;

import static com.iAxis.jumghor.entities.utils.EntityUtils.isValidIdentifier;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Component
public class PersistentInterceptor implements Interceptor {

    @Override
    public boolean onPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        if (entity.getClass().isAssignableFrom(PersistentEntity.class)) {
                Persistent<?> instance = (Persistent <?>) entity;

//                if (!isValidIdentifier(instance.getId()) && instance.getId() instanceof Long) {
//                    instance.setId(RandomGenerator.init().randomUUID());
//                }

                return true;
        }

        return false;
    }
}
