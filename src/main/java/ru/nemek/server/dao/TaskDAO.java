package ru.nemek.server.dao;

import ru.nemek.shared.dto.TaskDTO;

public class TaskDAO extends BaseDAO<TaskDTO> {
    public TaskDAO() {
        super(TaskDTO.class);
    }

}
