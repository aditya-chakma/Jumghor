package com.iAxis.jumghor.entities.interceptor;

import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Component
public class PersistentInterceptor implements Interceptor, Serializable {

    @Override
    public boolean onPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        // todo replace with logs.
        //System.out.println("=====Triggering pre persist=======");

        return false;
    }

}
