package ru.nemek.server.dao;


import ru.nemek.shared.dto.Task;

import java.util.List;
import static ru.nemek.server.dao.objectify.OfyService.ofy;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public Task getById(int id) {
        return null;
    }

    @Override
    public void save(Task task) {
        ofy().save().entity(task);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }


    @Override
    public List getAll() {
        return ofy().load().list();
    }
}
