package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.shared.dispatch.addTasksAction;
import ru.nemek.shared.dispatch.addTasksResult;

public class saveTaskHandller extends MyAbstractActionHandler<addTaskAction, addTaskResult> {
    private TaskDAO taskDAO;

    @Inject
    public saveTaskHandller() {
        super(addTasksAction.class);
    }

    @Override
    public addTasksResult execute(addTasksAction action, ExecutionContext context) throws ActionException {

        return null;
    }
}
