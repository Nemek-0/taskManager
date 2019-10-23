package ru.nemek.server.dispatch;


import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import ru.nemek.server.dispatch.common.AddTaskHandler;
import ru.nemek.server.dispatch.common.DeleteTaskHandler;
import ru.nemek.server.dispatch.common.GetTaskHandler;
import ru.nemek.server.dispatch.common.GetTasksHandler;
import ru.nemek.shared.dispatch.AddTaskAction;
import ru.nemek.shared.dispatch.DeleteTaskAction;
import ru.nemek.shared.dispatch.GetTaskAction;
import ru.nemek.shared.dispatch.GetTasksAction;

public class MyHandlerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {

        bindHandler(AddTaskAction.class, AddTaskHandler.class);
        bindHandler(GetTasksAction.class, GetTasksHandler.class);
        bindHandler(GetTaskAction.class, GetTaskHandler.class);
        bindHandler(DeleteTaskAction.class, DeleteTaskHandler.class);
    }
}
