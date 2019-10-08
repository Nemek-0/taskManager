package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.shared.dispatch.getTasksAction;
import ru.nemek.shared.dispatch.getTasksResult;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dispatch.MyAbstractActionHandler;


public class getTasksHandller extends MyAbstractActionHandler<getTasksAction, getTasksResult> {
    private TaskDAO taskDAO;

    @Inject
    public getTasksHandller() {
        super(getTasksAction.class);
    }


    @Override
    public getTasksResult execute(getTasksAction action, ExecutionContext context) throws ActionException {
        System.out.println(taskDAO.getAll().size());
        return new getTasksResult(taskDAO.getAll());
    }
}
