package ru.nemek.server.dao;

import ru.nemek.shared.dto.TaskDTO;
import ru.nemek.shared.entity.Task;

import java.util.List;

public interface TaskDAO {
    Task getById(int id);
    void save(TaskDTO task);
    void update(TaskDTO task);
    void delete(TaskDTO task);
    List getAll();

}
