package ru.nemek.shared.dto;

import java.util.Date;

public class Task extends Dto {
    private String task;
    private Date due;

    public String getTask() {
        return task;
    }

    public Date getDue() {
        return due;
    }
}
