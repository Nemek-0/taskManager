package ru.nemek.server.dao;

import ru.nemek.shared.dto.Task;

import java.util.List;

public interface TaskDAO {
    Task getById(int id);
    void save(Task task);
    void update(Task task);
    void delete(Task task);
    List getAll();

}
