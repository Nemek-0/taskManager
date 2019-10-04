package ru.nemek.shared.entity;

import java.util.Date;

public class Task extends BaseEntity {
    private String task;
    private Date due;

    public Task() {
    }

    public Task(String task, Date due){
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
}
