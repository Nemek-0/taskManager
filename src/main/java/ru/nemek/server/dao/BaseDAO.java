package ru.nemek.server.dao;

import java.util.List;

import static ru.nemek.server.dao.objectify.OfyService.ofy;

public abstract class BaseDAO<T> {
    private final Class<T> clazz;

    protected BaseDAO(final Class<T> clazz) {
        this.clazz = clazz;
    }


    public void save(T entity){
        ofy().save().entity(entity).now();
    }
    public List<T> getAll() {
        return ofy().load().type(clazz).list();
    }
}
