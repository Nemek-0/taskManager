package ru.nemek.client.application;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.Task;

interface ApplicationUiHandlers extends UiHandlers {

    void GoogleButton();
    void initFlexTable();
    void addTaskToFlexTable(Task task);
}
