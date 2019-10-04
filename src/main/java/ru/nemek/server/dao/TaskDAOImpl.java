package ru.nemek.server.dao;


import ru.nemek.shared.dto.TaskDTO;

import java.util.List;
import static ru.nemek.server.dao.objectify.OfyService.ofy;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public TaskDTO getById(int id) {
        return null;
    }

    @Override
    public void save(TaskDTO task) {
        ofy().save().entity(task);
    }

    @Override
    public void update(TaskDTO task) {

    }

    @Override
    public void delete(TaskDTO task) {

    }


    @Override
    public List getAll() {
        return ofy().load().list();
    }
}
