package ru.nemek.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.TaskDTO;

import java.util.Date;
import java.util.List;

interface HomeUiHandlers extends UiHandlers {
    void GoogleButton();
    void addTask(String Task, Date due);
    List<TaskDTO> updateTable();
}
