package ru.nemek.server.dao;





import ru.nemek.shared.dto.Task;

import java.util.List;

public interface TaskDAO {
    Task getById(int id);
    void save();
    void update();
    void delete();
    List<Task> getAll();

}
