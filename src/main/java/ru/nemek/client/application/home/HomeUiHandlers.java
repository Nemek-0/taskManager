package ru.nemek.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.TaskDTO;

interface HomeUiHandlers extends UiHandlers {
    void GoogleButton();
    void addTask(TaskDTO task);
    void updateTable();
    void addTaskTable(long id);
}
