package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.GetTasksAction;
import ru.nemek.shared.dispatch.GetTasksResult;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;


public class GetTasksHandler extends MyAbstractActionHandler<GetTasksAction, GetTasksResult> {

    @Inject
    public GetTasksHandler() {
        super(GetTasksAction.class);
    }


    @Override
    public GetTasksResult execute(GetTasksAction action, ExecutionContext context) throws ActionException {
        ArrayList<TaskDTO> list =  new TaskDAO().getAll();
        return new GetTasksResult(list);
    }
}
