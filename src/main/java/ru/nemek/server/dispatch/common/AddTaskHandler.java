package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.AddTaskAction;
import ru.nemek.shared.dispatch.AddTaskResult;
import ru.nemek.shared.dto.TaskDTO;

public class AddTaskHandler extends MyAbstractActionHandler<AddTaskAction, AddTaskResult> {

    @Inject
    public AddTaskHandler() {
        super(AddTaskAction.class);
    }

    @Override
    public AddTaskResult execute(AddTaskAction action, ExecutionContext context) throws ActionException {
        TaskDTO task = new TaskDAO().saveAndReturn(action.getTask());
        return new AddTaskResult(task);
    }
}
