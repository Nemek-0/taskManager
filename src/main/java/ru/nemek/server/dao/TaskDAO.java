package ru.nemek.server.dao;

import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;

public class TaskDAO extends BaseDAO<TaskDTO> {
    public TaskDAO() {
        super(TaskDTO.class);
    }

    public void saveTask (TaskDTO task){
       this.save(task);
    }

    public ArrayList<TaskDTO> getTasks(){
        return this.getAll();
    }

    public TaskDTO getTaskById(long id){
        return this.get(id);
    }

    public TaskDTO saveTaskAndReturn(TaskDTO task){
        return this.saveAndReturn(task);
    }
}
