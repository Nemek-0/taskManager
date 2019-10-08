package ru.nemek.server.dispatch;


import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import ru.nemek.server.dispatch.common.getTasksHandller;
import ru.nemek.server.dispatch.common.addTaskHandller;
import ru.nemek.shared.dispatch.addTaskAction;
import ru.nemek.shared.dispatch.getTasksAction;

public class MyHandlerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {

        bindHandler(addTaskAction.class, addTaskHandller.class);
        bindHandler(getTasksAction.class, getTasksHandller.class);

    }
}
