package ru.nemek.server.dao;

import ru.nemek.shared.dto.TaskDTO;

import static ru.nemek.server.dao.objectify.OfyService.ofy;

public class TaskDAO extends BaseDAO<TaskDTO> {
    public TaskDAO() {
        super(TaskDTO.class);
    }

    public void save (TaskDTO task){
        ofy().save().entity(task).now();
    }


}
