package ru.nemek.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;

import java.util.Date;

interface HomeUiHandlers extends UiHandlers {
    void saveTask(String taskString, Date due);
    void updateTable();
    void addTaskInTable(long id);
}
