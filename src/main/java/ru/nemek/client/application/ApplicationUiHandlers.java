package ru.nemek.client.application;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.Task;

import java.util.Date;

interface ApplicationUiHandlers extends UiHandlers {

    void GoogleButton();
    void addTask(String Task, Date due);
}
