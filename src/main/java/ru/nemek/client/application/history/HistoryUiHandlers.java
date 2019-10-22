package ru.nemek.client.application.history;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.nemek.shared.dto.TaskDTO;

interface HistoryUiHandlers extends UiHandlers {
    void returnTask(TaskDTO task);
}
