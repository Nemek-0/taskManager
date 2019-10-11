package ru.nemek.shared.dto;

import com.googlecode.objectify.annotation.Entity;

import java.util.Date;


@Entity
public class TaskDTO extends Dto {
    private String task;
    private Date due;



    public TaskDTO() {
    }

    public TaskDTO(String task, Date due){
        this.task = task;
        this.due = due;
    }

    public String getTask() {
        return task;
    }

    public Date getDue() {
        return due;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "task='" + task + '\'' +
                ", due=" + due +
                '}';
    }
}
