package ru.nemek.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.TaskDTO;

interface HomeUiHandlers extends UiHandlers {
    void saveTask(TaskDTO taskDTO);
    void updateTable();
    void deleteTask(TaskDTO task);
    void onDeleteTaskEvent(TaskDTO task);
}
