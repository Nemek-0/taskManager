package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.addTaskAction;
import ru.nemek.shared.dispatch.addTaskResult;

public class saveTaskHandller extends MyAbstractActionHandler<addTaskAction, addTaskResult> {
    private TaskDAO taskDAO;

    @Inject
    public saveTaskHandller() {
        super(addTaskAction.class);
    }

    @Override
    public addTaskResult execute(addTaskAction action, ExecutionContext context) throws ActionException {
        System.out.println("LOg");
        taskDAO.save(action.getTask());
        return new addTaskResult();
    }
}
