package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.FetchTaskResult;
import ru.nemek.shared.entity.Task;

import java.util.List;

public class getTasks extends MyAbstractActionHandler<FetchTaskResult> {

    private final TaskDAO taskDAO;

    @Inject
    public getTasks(TaskDAO taskDAO) {
        super(getTasks.class);
        this.taskDAO = taskDAO;
    }

    @Override
    public Result execute(Action action, ExecutionContext executionContext) throws ActionException {
        Task tasks = taskDAO.getById(0);
         return new getTasks(tasks);

    }
}
