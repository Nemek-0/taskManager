package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.GetTaskAction;
import ru.nemek.shared.dispatch.GetTaskResult;

public class GetTaskHandller extends MyAbstractActionHandler<GetTaskAction, GetTaskResult> {
    @Inject
    public GetTaskHandller() {
        super(GetTaskAction.class);
    }


    @Override
    public GetTaskResult execute(GetTaskAction action, ExecutionContext context) throws ActionException {
        return new GetTaskResult(new TaskDAO().get(action.getId()));
    }
}
