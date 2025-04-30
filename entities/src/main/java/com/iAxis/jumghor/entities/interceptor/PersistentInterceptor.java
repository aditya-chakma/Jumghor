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
        System.out.println("=====Triggering pre persist=======");
        // todo replace with logs.

        return false;
    }


}
