package ru.nemek.server.dao.objectify;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory{
    private Injector injector;

    @Inject
    public OfyFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public <T> T construct(Class<T> type) {
        return injector.getInstance(type);
    }
}
