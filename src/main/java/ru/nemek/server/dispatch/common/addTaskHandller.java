package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.addTaskAction;
import ru.nemek.shared.dispatch.addTaskResult;

public class addTaskHandller extends MyAbstractActionHandler<addTaskAction, addTaskResult> {

    @Inject
    public addTaskHandller() {
        super(addTaskAction.class);
    }

    @Override
    public addTaskResult execute(addTaskAction action, ExecutionContext context) throws ActionException {
        new TaskDAO().save(action.getTask());
        return new addTaskResult();
    }
}
