package ru.nemek.shared.dto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;
import java.util.Date;


@Entity
public class TaskDTO implements Serializable {
    @Id
    private Long id;
    private String task;
    private Date due;

    public TaskDTO() {
    }

    public TaskDTO(String task, Date due){
        this.task = task;
        this.due = due;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
