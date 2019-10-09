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
        List<T> tasks = ofy().load().type(clazz).list();
        System.out.println(tasks);
        return tasks;
    }

    public T get(Long id) {
        // TODO probably it could be fixed by parameters of
        // work around for objectify cacheing and new query not having the
        // latest
        // data
        // ofy().clear();

        return ofy().load().type(clazz).id(id).now();
    }

}
