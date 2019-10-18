package ru.nemek.server.dao;

import com.googlecode.objectify.Key;

import java.util.ArrayList;

import static ru.nemek.server.dao.objectify.OfyService.ofy;

public abstract class BaseDAO<T> {
    private final Class<T> clazz;

    BaseDAO(final Class<T> clazz) {
        this.clazz = clazz;
    }


    void save(T entity){
        ofy().save().entity(entity).now();
    }

    public ArrayList<T> getAll() {
        return new ArrayList<T>(ofy().load().type(clazz).list());
    }

    public T get(Long id) {
        // TODO probably it could be fixed by parameters of
        // work around for objectify cacheing and new query not having the
        // latest
        // data
        // ofy().clear();

        return ofy().load().type(clazz).id(id).now();
    }

    private T get(Key<T> key) {
        return ofy().load().key(key).now();
    }

    private Key<T> saveNow(T entity) {
        return ofy().save().entity(entity).now();
    }

    T saveAndReturn(T entity) {
        // saveNow(entity);
        // return entity;
        return get(saveNow(entity));
    }

}
