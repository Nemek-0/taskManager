package ru.nemek.server.dispatch;


import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import ru.nemek.server.dispatch.common.AddTaskHandller;
import ru.nemek.server.dispatch.common.DeleteTaskHandller;
import ru.nemek.server.dispatch.common.GetTaskHandller;
import ru.nemek.server.dispatch.common.GetTasksHandller;
import ru.nemek.shared.dispatch.AddTaskAction;
import ru.nemek.shared.dispatch.DeleteTaskAction;
import ru.nemek.shared.dispatch.GetTaskAction;
import ru.nemek.shared.dispatch.GetTasksAction;

public class MyHandlerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {

        bindHandler(AddTaskAction.class, AddTaskHandller.class);
        bindHandler(GetTasksAction.class, GetTasksHandller.class);
        bindHandler(GetTaskAction.class, GetTaskHandller.class);
        bindHandler(DeleteTaskAction.class, DeleteTaskHandller.class);
    }
}
