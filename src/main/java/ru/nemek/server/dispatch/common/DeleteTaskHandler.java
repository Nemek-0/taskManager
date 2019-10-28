package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.DeleteTaskAction;
import ru.nemek.shared.dispatch.DeleteTaskResult;


public class DeleteTaskHandler extends MyAbstractActionHandler<DeleteTaskAction, DeleteTaskResult> {
    @Inject
    public DeleteTaskHandler() {
        super(DeleteTaskAction.class);
    }

    @Override
    public DeleteTaskResult execute(DeleteTaskAction deleteTaskAction, ExecutionContext executionContext) throws ActionException {
        new TaskDAO().deleteById(deleteTaskAction.getId());
        return new DeleteTaskResult();
    }
}
