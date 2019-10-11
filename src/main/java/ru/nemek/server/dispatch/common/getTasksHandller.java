package ru.nemek.server.dispatch.common;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dispatch.MyAbstractActionHandler;
import ru.nemek.shared.dispatch.getTasksAction;
import ru.nemek.shared.dispatch.getTasksResult;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;


public class getTasksHandller extends MyAbstractActionHandler<getTasksAction, getTasksResult> {

    @Inject
    public getTasksHandller() {
        super(getTasksAction.class);
    }


    @Override
    public getTasksResult execute(getTasksAction action, ExecutionContext context) throws ActionException {
        ArrayList<TaskDTO> list =  new TaskDAO().getAll();
        System.out.println(list);
        return new getTasksResult(list);
    }
}
