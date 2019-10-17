package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.getTaskAction;
import ru.nemek.shared.dispatch.getTaskResult;

public class getTaskHandller extends MyAbstractActionHandler<getTaskAction, getTaskResult> {
    @Inject
    public getTaskHandller() {
        super(getTaskAction.class);
    }


    @Override
    public getTaskResult execute(getTaskAction action, ExecutionContext context) throws ActionException {
        return new getTaskResult(new TaskDAO().get(action.getId()));
    }
}
